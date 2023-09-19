package com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActiveDTO {

    private UUID id;

    @NotNull(message = "O nome do ativo é obrigatório")
    @NotBlank(message = "O nome do ativo é obrigatório")
    @Size(min = 3, message = "O nome do ativo precisar ter pelo menos 3 caracteres")
    private String name;

    @NotNull(message = "A descrição do ativo é obrigatória")
    @NotBlank(message = "A descrição do ativo é obrigatória")
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
