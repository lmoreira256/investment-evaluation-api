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
                .quantity(activeDTO.getQuantity())
                .currentValue(activeDTO.getCurrentValue())
                .costValue(activeDTO.getCostValue())
                .averageCost(activeDTO.getAverageCost())
                .netResult(activeDTO.getNetResult())
                .percentageResult(activeDTO.getPercentageResult())
                .activeType(ActiveTypeEnum.valueOf(activeDTO.getActiveType()))
                .enabled(Objects.isNull(activeDTO.getEnabled()) || activeDTO.getEnabled())
                .objective(activeDTO.getObjective())
                .currentPrice(activeDTO.getCurrentPrice())
                .build();
    }

    public static ActiveDTO buildDTO(Active active) {
        return ActiveDTO.builder()
                .id(active.getId())
                .name(active.getName())
                .description(active.getDescription())
                .quantity(active.getQuantity())
                .currentValue(active.getCurrentValue())
                .netResult(active.getNetResult())
                .percentageResult(active.getPercentageResult())
                .costValue(active.getCostValue())
                .averageCost(active.getAverageCost())
                .activeType(active.getActiveType().name())
                .createdAt(active.getCreatedAt())
                .updatedAt(active.getUpdatedAt())
                .enabled(active.getEnabled())
                .objective(active.getObjective())
                .currentPrice(active.getCurrentPrice())
                .build();
    }

    public static List<ActiveDTO> buildListDTO(List<Active> activeList) {
        return activeList.stream().map(ActiveFactory::buildDTO).collect(Collectors.toList());
    }

}
