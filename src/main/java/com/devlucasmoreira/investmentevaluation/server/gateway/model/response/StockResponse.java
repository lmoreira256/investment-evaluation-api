package com.devlucasmoreira.investmentevaluation.server.gateway.model.response;

import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockResponse {

    private UUID id;

    private String active;

    private String description;

    private Integer amount;

    private BigDecimal currentValue;

    private BigDecimal cashReturn;

    private BigDecimal profitability;

    private BigDecimal purchaseValue;

    private BigDecimal averagePurchase;

    private StockTypeEnum stockType;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
