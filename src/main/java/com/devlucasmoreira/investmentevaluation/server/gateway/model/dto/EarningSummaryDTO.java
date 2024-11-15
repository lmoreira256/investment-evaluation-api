package com.devlucasmoreira.investmentevaluation.server.gateway.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EarningSummaryDTO {

    private String item;

    private BigDecimal totalValue;

}
