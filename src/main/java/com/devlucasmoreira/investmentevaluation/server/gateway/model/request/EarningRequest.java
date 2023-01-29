package com.devlucasmoreira.investmentevaluation.server.gateway.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EarningRequest {

    private UUID idStock;

    private String stockName;

    private BigDecimal currentValue;

    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Brazil/East")
    private LocalDateTime createdAt;

}
