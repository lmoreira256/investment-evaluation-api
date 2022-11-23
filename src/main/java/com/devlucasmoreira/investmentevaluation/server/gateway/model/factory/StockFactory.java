package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockResponse;
import org.springframework.data.domain.Page;

public class StockFactory {

    public static Stock build(StockRequest stockRequest) {
        return Stock.builder()
                .active(stockRequest.getActive())
                .description(stockRequest.getDescription())
                .amount(stockRequest.getAmount())
                .currentValue(stockRequest.getCurrentValue())
                .purchaseValue(stockRequest.getPurchaseValue())
                .averagePurchase(stockRequest.getAveragePurchase())
                .stockType(stockRequest.getStockType())
                .build();
    }

    public static StockResponse buildResponse(Stock stock) {
        return StockResponse.builder()
                .id(stock.getId())
                .active(stock.getActive())
                .description(stock.getDescription())
                .amount(stock.getAmount())
                .currentValue(stock.getCurrentValue())
                .cashReturn(stock.getCashReturn())
                .profitability(stock.getProfitability())
                .purchaseValue(stock.getPurchaseValue())
                .averagePurchase(stock.getAveragePurchase())
                .stockType(stock.getStockType())
                .createdAt(stock.getCreatedAt())
                .updatedAt(stock.getUpdatedAt())
                .build();
    }

    public static Page<StockResponse> buildPageResponse(Page<Stock> stockPage) {
        return stockPage.map(StockFactory::buildResponse);
    }

}
