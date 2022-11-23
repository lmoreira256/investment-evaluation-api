package com.devlucasmoreira.investmentevaluation.server.gateway.model.request;

import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRequest {

    private String active;

    private String description;

    private Integer amount;

    private BigDecimal currentValue;

    private BigDecimal purchaseValue;

    private BigDecimal averagePurchase;

    private StockTypeEnum stockType;

}
