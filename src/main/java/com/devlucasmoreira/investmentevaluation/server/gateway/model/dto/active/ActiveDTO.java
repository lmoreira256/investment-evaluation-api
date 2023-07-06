package com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActiveDTO {

    private UUID id;

    private String name;

    private String description;

    private Integer amount;

    private BigDecimal currentValue;

    private BigDecimal resultValue;

    private BigDecimal resultPercentageValue;

    private BigDecimal purchaseValue;

    private BigDecimal averageValue;

    private ActiveTypeEnum activeType;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private Boolean enabled;

    private Integer objective;

}
