package com.devlucasmoreira.investmentevaluation.server.service.coin;

import com.devlucasmoreira.investmentevaluation.server.domain.Coin;
import com.devlucasmoreira.investmentevaluation.server.exception.CoinAlreadyExistsException;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CoinFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.CoinRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinCreateService {

    @Autowired
    private CoinRepository coinRepository;

    public CoinResponse execute(CoinRequest coinRequest) {
        Coin coin = CoinFactory.build(coinRequest);

        if (coinRepository.existsByName(coin.getName())) {
            throw new CoinAlreadyExistsException();
        }

        return CoinFactory.buildResponse(coinRepository.save(coin));
    }

}
