package com.devlucasmoreira.investmentevaluation.server.gateway.model.response;

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
public class EarningResponse {

    private UUID id;

    private String activeName;

    private BigDecimal amountPaid;

    private String description;

    private LocalDateTime payday;

}
