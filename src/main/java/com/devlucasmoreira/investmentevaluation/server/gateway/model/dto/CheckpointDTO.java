package com.devlucasmoreira.investmentevaluation.server.gateway.model.dto;

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
public class CheckpointDTO {

    private UUID id;

    private Integer amount;

    private BigDecimal currentValue;

    private BigDecimal purchaseValue;

    private BigDecimal resultValue;

    private BigDecimal resultPercentageValue;

    private LocalDateTime createdAt;

}
