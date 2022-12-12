package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.Stock;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class StockUpdateValuesService {

    public Stock execute(Stock stock) {
        BigDecimal currentValue = stock.getCurrentValue();
        BigDecimal purchaseValue = stock.getPurchaseValue();
        BigDecimal cashReturn = currentValue.subtract(purchaseValue);
        BigDecimal profitability = currentValue.equals(BigDecimal.ZERO) ? BigDecimal.ZERO :
                currentValue.multiply(new BigDecimal(100))
                        .divide(purchaseValue, 2, RoundingMode.HALF_UP).subtract(new BigDecimal(100));

        stock.setCashReturn(cashReturn);
        stock.setProfitability(profitability);

        return stock;
    }

}
