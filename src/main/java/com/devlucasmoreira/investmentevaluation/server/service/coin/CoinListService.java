package com.devlucasmoreira.investmentevaluation.server.service.coin;

import com.devlucasmoreira.investmentevaluation.server.domain.Coin;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CoinFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoinListService {

    @Autowired
    private CoinRepository coinRepository;

    public Page<CoinResponse> execute(String name, Pageable pageable) {
        Page<Coin> coinPage = name == null || name.length() == 0
                ? coinRepository.findAll(pageable) : coinRepository.findByName(name.toUpperCase(), pageable);

        return CoinFactory.buildPageResponse(coinPage);
    }

}
