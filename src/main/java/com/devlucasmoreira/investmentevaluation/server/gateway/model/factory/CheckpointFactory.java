package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Checkpoint;
import com.devlucasmoreira.investmentevaluation.server.domain.StockCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.CheckpointDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CheckpointFactory {

    public static CheckpointDTO buildDTO(StockCheckpoint stockCheckpoint) {
        return CheckpointDTO.builder()
                .amount(stockCheckpoint.getAmount())
                .currentValue(stockCheckpoint.getCurrentValue())
                .purchaseValue(stockCheckpoint.getPurchaseValue())
                .resultValue(stockCheckpoint.getResultValue())
                .resultPercentageValue(stockCheckpoint.getResultPercentageValue())
                .createdAt(stockCheckpoint.getCreatedAt())
                .build();
    }

    public static CheckpointDTO buildDTO(Checkpoint checkpoint) {
        return CheckpointDTO.builder()
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

    public static List<CheckpointDTO> buildListStockChecklistDTO(List<StockCheckpoint> stockCheckpoints) {
        return stockCheckpoints.stream().map(CheckpointFactory::buildDTO).collect(Collectors.toList());
    }

}
