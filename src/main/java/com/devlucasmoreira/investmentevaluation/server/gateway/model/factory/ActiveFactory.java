package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ActiveFactory {

    public static Active build(ActiveDTO activeDTO) {
        return Active.builder()
                .name(activeDTO.getName())
                .description(activeDTO.getDescription())
                .amount(activeDTO.getAmount())
                .currentValue(activeDTO.getCurrentValue())
                .purchaseValue(activeDTO.getPurchaseValue())
                .averageValue(activeDTO.getAverageValue())
                .resultValue(activeDTO.getResultValue())
                .resultPercentageValue(activeDTO.getResultPercentageValue())
                .activeType(ActiveTypeEnum.valueOf(activeDTO.getActiveType()))
                .enabled(Objects.isNull(activeDTO.getEnabled()) || activeDTO.getEnabled())
                .objective(activeDTO.getObjective())
                .build();
    }

    public static ActiveDTO buildDTO(Active active) {
        return ActiveDTO.builder()
                .id(active.getId())
                .name(active.getName())
                .description(active.getDescription())
                .amount(active.getAmount())
                .currentValue(active.getCurrentValue())
                .resultValue(active.getResultValue())
                .resultPercentageValue(active.getResultPercentageValue())
                .purchaseValue(active.getPurchaseValue())
                .averageValue(active.getAverageValue())
                .activeType(active.getActiveType().name())
                .createdAt(active.getCreatedAt())
                .updatedAt(active.getUpdatedAt())
                .enabled(active.getEnabled())
                .objective(active.getObjective())
                .build();
    }

    public static List<ActiveDTO> buildListDTO(List<Active> activeList) {
        return activeList.stream().map(ActiveFactory::buildDTO).collect(Collectors.toList());
    }

}
