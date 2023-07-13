package com.devlucasmoreira.investmentevaluation.server.gateway.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckpointDTO {

    private Integer amount;

    private BigDecimal currentValue;

    private BigDecimal purchaseValue;

    private BigDecimal resultValue;

    private BigDecimal resultPercentageValue;

    private LocalDateTime createdAt;

}
