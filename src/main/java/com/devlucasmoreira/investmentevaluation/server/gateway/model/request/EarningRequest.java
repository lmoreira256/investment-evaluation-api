package com.devlucasmoreira.investmentevaluation.server.gateway.model.request;

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
public class EarningRequest {

    private UUID stockId;

    private BigDecimal amountPaid;

    private String description;

    private LocalDateTime payday;

}
