package com.devlucasmoreira.investmentevaluation.server.gateway.model.response;

import com.devlucasmoreira.investmentevaluation.server.enums.StockHistoricTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockHistoricResponse {

    private UUID id;

    private BigDecimal actualValue;

    private BigDecimal purchaseValue;

    private Integer amount;

    private BigDecimal cashReturn;

    private BigDecimal profitability;

    private StockHistoricTypeEnum historicType;

    private LocalDateTime createdAt;

}
