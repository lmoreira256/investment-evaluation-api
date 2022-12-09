package com.devlucasmoreira.investmentevaluation.server.gateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EarningSummaryResponse {

    private List<EarningStockSummaryResponse> earningStockSummary;

    private List<EarningMonthSummaryResponse> earningMonthSummary;

    private BigDecimal totalValue;

}
