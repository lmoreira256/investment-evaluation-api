package com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active;

import com.devlucasmoreira.investmentevaluation.server.config.annotation.EnumNamePattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
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
    @NotBlank(message = "O nome do ativo não pode ser vazio")
    @Size(min = 3, message = "O nome do ativo precisar ter pelo menos 3 caracteres")
    @Size(max = 6, message = "O nome do ativo não pode passar de 6 caracteres")
    private String name;

    @NotNull(message = "A descrição do ativo é obrigatória")
    @NotBlank(message = "A descrição do ativo não pode ser vazia")
    @Size(max = 255, message = "O nome do ativo não pode passar de 255 caracteres")
    private String description;

    @NotNull(message = "A quantidade do ativo é obrigatória")
    @Min(value = 0, message = "A quantidade do ativo precisa ser maior ou igual à 0")
    private Integer quantity;

    @NotNull(message = "O valor atual do ativo é obrigatório")
    @Min(value = 0, message = "O valor atual do ativo precisa ser maior ou igual à 0")
    private BigDecimal currentValue;

    @NotNull(message = "O resultado do ativo é obrigatório")
    @Min(value = 0, message = "O resultado do ativo precisa ser maior ou igual à 0")
    private BigDecimal netResult;

    @NotNull(message = "A porcentagem do resultado do ativo é obrigatória")
    @Min(value = 0, message = "A porcentagem do resultado do ativo precisa ser maior ou igual à 0")
    private BigDecimal percentageResult;

    @NotNull(message = "O valor de compra do ativo é obrigatório")
    @Min(value = 0, message = "O valor de compra do ativo precisa ser maior ou igual à 0")
    private BigDecimal costValue;

    @NotNull(message = "A média de compra do ativo é obrigatória")
    @Min(value = 0, message = "A média de compra do ativo precisa ser maior ou igual à 0")
    private BigDecimal averageCost;

    @EnumNamePattern(regexp = "STOCK|REAL_ESTATE_FUND", message = "O tipo do ativo deve ser entre esses valores: STOCK ou REAL_ESTATE_FUND")
    private String activeType;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private Boolean enabled;

    @NotNull(message = "O objetivo de compra do ativo é obrigatório")
    @Min(value = 0, message = "O objetivo de compra do ativo precisa ser maior ou igual à 0")
    private Integer objective;

    @NotNull(message = "O valor atual do ativo é obrigatório")
    @Min(value = 0, message = "O valor atual do ativo precisa ser maior ou igual à 0")
    private BigDecimal currentPrice;

    private Integer quantityToBuy;

}
