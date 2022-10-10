package com.devlucasmoreira.investmentevaluation.server.gateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinResponse {

    private UUID id;

    private String name;

    private BigDecimal amount;

    private BigDecimal currentValue;

}
