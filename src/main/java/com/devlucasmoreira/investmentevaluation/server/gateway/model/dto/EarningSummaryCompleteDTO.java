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
public class EarningSummaryCompleteDTO {

    private BigDecimal totalReceived;

    private BigDecimal totalLastMonth;

    private BigDecimal totalLastYear;

    private BigDecimal performancePercentage;

}
