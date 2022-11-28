package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import org.springframework.data.domain.Page;

public class EarningFactory {

    public static Earning build(EarningRequest earningRequest, Stock stock) {
        return Earning.builder()
                .createdAt(earningRequest.getCreatedAt())
                .currentValue(earningRequest.getCurrentValue())
                .description(earningRequest.getDescription())
                .stock(stock)
                .build();
    }

    public static EarningResponse buildResponse(Earning earning) {
        return EarningResponse.builder()
                .createdAt(earning.getCreatedAt())
                .currentValue(earning.getCurrentValue())
                .description(earning.getDescription())
                .id(earning.getId())
                .idStock(earning.getStock().getId())
                .build();
    }

    public static Page<EarningResponse> buildPageResponse(Page<Earning> earningPage) {
        return earningPage.map(EarningFactory::buildResponse);
    }

}
