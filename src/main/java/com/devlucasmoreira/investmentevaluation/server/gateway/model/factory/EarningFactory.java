package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningMonthSummaryResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningStockSummaryResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class EarningFactory {

    public static Earning build(EarningRequest earningRequest, Stock stock) {
        return Earning.builder()
                .createdAt(earningRequest.getCreatedAt())
                .amountPaid(earningRequest.getCurrentValue())
                .description(earningRequest.getDescription())
                .stock(stock)
                .build();
    }

    public static EarningResponse buildResponse(Earning earning) {
        return EarningResponse.builder()
                .payday(earning.getPayday())
                .currentValue(earning.getAmountPaid())
                .description(earning.getDescription())
                .id(earning.getId())
                .stockName(earning.getStock().getActive())
                .build();
    }

    public static Page<EarningResponse> buildPageResponse(Page<Earning> earningPage) {
        return earningPage.map(EarningFactory::buildResponse);
    }

    public static EarningStockSummaryResponse buildStockSummaryResponse(String active, BigDecimal value) {
        return EarningStockSummaryResponse.builder()
                .active(active)
                .totalValue(value)
                .build();
    }

    public static EarningMonthSummaryResponse buildMonthSummaryResponse(String month, BigDecimal value) {
        return EarningMonthSummaryResponse.builder()
                .month(month)
                .totalValue(value)
                .build();
    }

}
