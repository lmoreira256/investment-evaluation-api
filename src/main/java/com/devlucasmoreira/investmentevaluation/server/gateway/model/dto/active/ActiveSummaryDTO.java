package com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActiveSummaryDTO {

    private Integer amount;

    private BigDecimal currentValue;

    private BigDecimal purchaseValue;

    private BigDecimal resultValue;

    private BigDecimal resultPercentageValue;

}
