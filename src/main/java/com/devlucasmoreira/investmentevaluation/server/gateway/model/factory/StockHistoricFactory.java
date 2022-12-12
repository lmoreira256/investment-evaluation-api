package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.StockHistoric;
import com.devlucasmoreira.investmentevaluation.server.enums.StockHistoricTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockHistoricCreationResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockHistoricResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

public class StockHistoricFactory {

    public static StockHistoric build(BigDecimal actualValue, BigDecimal purchaseValue, Integer amount, StockHistoricTypeEnum historicType) {
        MathContext mc = new MathContext(3);
        BigDecimal cashReturn = actualValue.subtract(purchaseValue);
        BigDecimal profitability = cashReturn.multiply(new BigDecimal(100)).divide(purchaseValue, mc);

        return StockHistoric.builder()
                .actualValue(actualValue)
                .purchaseValue(purchaseValue)
                .amount(amount)
                .cashReturn(cashReturn)
                .profitability(profitability)
                .historicType(historicType)
                .build();
    }

    public static StockHistoricResponse buildResponse(StockHistoric stockHistoric) {
        return StockHistoricResponse.builder()
                .id(stockHistoric.getId())
                .actualValue(stockHistoric.getActualValue())
                .purchaseValue(stockHistoric.getPurchaseValue())
                .amount(stockHistoric.getAmount())
                .cashReturn(stockHistoric.getCashReturn())
                .profitability(stockHistoric.getProfitability())
                .historicType(stockHistoric.getHistoricType())
                .createdAt(stockHistoric.getCreatedAt())
                .build();
    }

    public static StockHistoricCreationResponse buildResponse(List<StockHistoric> stockHistoricList) {
        return StockHistoricCreationResponse.builder()
                .stockHistoricResponse(stockHistoricList.stream().map(StockHistoricFactory::buildResponse).collect(Collectors.toList()))
                .build();
    }

    public static Page<StockHistoricResponse> buildPageResponse(Page<StockHistoric> stockHistoricPage) {
        return stockHistoricPage.map(StockHistoricFactory::buildResponse);
    }

}
