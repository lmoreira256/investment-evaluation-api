package com.devlucasmoreira.investmentevaluation.server.gateway.model.response;

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
public class CoinHistoricResponse {

    private BigDecimal actualValue;

    private LocalDateTime createdAt;

    private BigDecimal amount;

    private BigDecimal cashReturn;

    private BigDecimal profitability;

}
