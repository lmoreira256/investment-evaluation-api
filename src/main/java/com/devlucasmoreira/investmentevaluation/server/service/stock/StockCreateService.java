package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import com.devlucasmoreira.investmentevaluation.server.exception.StockAlreadyExistsException;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.StockRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class StockCreateService {

    @Autowired
    private StockRepository stockRepository;

    public StockResponse execute(StockRequest stockRequest) {
        validateStock(stockRequest);

        Stock stock = StockFactory.build(stockRequest);

        MathContext mc = new MathContext(2);
        BigDecimal currentValue = stock.getCurrentValue();
        BigDecimal purchaseValue = stock.getPurchaseValue();
        BigDecimal profit = currentValue.subtract(purchaseValue);
        BigDecimal profitability = currentValue.multiply(new BigDecimal(100))
                .divide(purchaseValue, 2, RoundingMode.HALF_UP).subtract(new BigDecimal(100));

        stock.setCashReturn(profit);
        stock.setProfitability(profitability);

        return StockFactory.buildResponse(stockRepository.save(stock));
    }

    private void validateStock(StockRequest stockRequest) {
        if (stockRepository.existsByActive(stockRequest.getActive())) {
            throw new StockAlreadyExistsException();
        }
    }

}
