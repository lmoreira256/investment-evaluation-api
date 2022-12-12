package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.CoinHistoric;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinHistoricResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;

public class CoinHistoricFactory {

    public static CoinHistoric build(BigDecimal amount, BigDecimal actualValue, BigDecimal cashReturn, BigDecimal totalValueDeposit) {
        MathContext mc = new MathContext(3);

        return CoinHistoric.builder()
                .amount(amount)
                .actualValue(actualValue)
                .cashReturn(cashReturn)
                .profitability(cashReturn.multiply(new BigDecimal(100)).divide(totalValueDeposit, mc))
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static CoinHistoricResponse buildResponse(CoinHistoric historic) {
        return CoinHistoricResponse.builder()
                .amount(historic.getAmount())
                .cashReturn(historic.getCashReturn())
                .createdAt(historic.getCreatedAt())
                .profitability(historic.getProfitability())
                .actualValue(historic.getActualValue())
                .build();
    }

    public static Page<CoinHistoricResponse> buildPageResponse(Page<CoinHistoric> coinHistoricPage) {
        return coinHistoricPage.map(CoinHistoricFactory::buildResponse);
    }


}
