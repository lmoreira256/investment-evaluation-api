package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Checkpoint;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.CheckpointDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CheckpointFactory {

    public static Checkpoint build(CheckpointDTO checkpointDTO) {
        return Checkpoint.builder()
                .id(checkpointDTO.getId())
                .amount(checkpointDTO.getAmount())
                .currentValue(checkpointDTO.getCurrentValue())
                .purchaseValue(checkpointDTO.getPurchaseValue())
                .resultValue(checkpointDTO.getResultValue())
                .resultPercentageValue(checkpointDTO.getResultPercentageValue())
                .createdAt(checkpointDTO.getCreatedAt())
                .build();
    }

    public static CheckpointDTO buildDTO(Checkpoint checkpoint) {
        return CheckpointDTO.builder()
                .id(checkpoint.getId())
                .amount(checkpoint.getAmount())
                .currentValue(checkpoint.getCurrentValue())
                .purchaseValue(checkpoint.getPurchaseValue())
                .resultValue(checkpoint.getResultValue())
                .resultPercentageValue(checkpoint.getResultPercentageValue())
                .createdAt(checkpoint.getCreatedAt())
                .build();
    }

    public static List<CheckpointDTO> buildListDTO(List<Checkpoint> checkpointList) {
        return checkpointList.stream().map(CheckpointFactory::buildDTO).collect(Collectors.toList());
    }

}
