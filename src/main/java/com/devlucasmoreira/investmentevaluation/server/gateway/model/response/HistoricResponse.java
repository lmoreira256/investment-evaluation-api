package com.devlucasmoreira.investmentevaluation.server.gateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoricResponse {

    private BigDecimal value;

    private LocalDate date;

    private BigDecimal amount;

    private BigDecimal cashReturn;

    private BigDecimal profitability;

}
