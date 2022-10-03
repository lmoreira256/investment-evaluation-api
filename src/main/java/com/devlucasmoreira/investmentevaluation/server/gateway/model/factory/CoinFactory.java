package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Coin;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.CoinRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinResponse;

public class CoinFactory {

    public static Coin build(CoinRequest coinRequest) {
        return Coin.builder()
                .amount(coinRequest.getAmount())
                .currentValue(coinRequest.getCurrentValue())
                .name(coinRequest.getName())
                .build();
    }

    public static CoinResponse buildResponse(Coin coin) {
        return CoinResponse.builder()
                .amount(coin.getAmount())
                .currentValue(coin.getCurrentValue())
                .name(coin.getName())
                .build();
    }

}
