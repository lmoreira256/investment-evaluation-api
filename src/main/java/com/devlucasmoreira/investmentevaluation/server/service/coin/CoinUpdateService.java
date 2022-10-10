package com.devlucasmoreira.investmentevaluation.server.service.coin;

import com.devlucasmoreira.investmentevaluation.server.domain.Coin;
import com.devlucasmoreira.investmentevaluation.server.exception.CoinNotFoundException;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CoinFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.CoinRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class CoinUpdateService {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CoinRepository coinRepository;

    public CoinResponse execute(UUID id, CoinRequest coinRequest) {
        Coin coin = coinRepository.findById(id).orElseThrow(CoinNotFoundException::new);

        if (coinRequest.getAmount() != null) {
            coin.setAmount(coinRequest.getAmount());
        }

        if (coinRequest.getCurrentValue() != null) {
            coin.setCurrentValue(coinRequest.getCurrentValue());
        }

        Objects.requireNonNull(cacheManager.getCache("coinList")).clear();
        return CoinFactory.buildResponse(coinRepository.save(coin));
    }

}
