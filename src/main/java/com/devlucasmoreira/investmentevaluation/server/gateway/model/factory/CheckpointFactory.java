package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Checkpoint;
import com.devlucasmoreira.investmentevaluation.server.domain.RealEstateFundCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.domain.StockCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.CheckpointDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CheckpointFactory {

    public static CheckpointDTO buildDTO(RealEstateFundCheckpoint realEstateFundCheckpoint) {
        return CheckpointDTO.builder()
                .amount(realEstateFundCheckpoint.getAmount())
                .currentValue(realEstateFundCheckpoint.getCurrentValue())
                .purchaseValue(realEstateFundCheckpoint.getPurchaseValue())
                .resultValue(realEstateFundCheckpoint.getResultValue())
                .resultPercentageValue(realEstateFundCheckpoint.getResultPercentageValue())
                .createdAt(realEstateFundCheckpoint.getCreatedAt())
                .build();
    }

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

    public static List<CheckpointDTO> buildListStockCheckpointDTO(List<StockCheckpoint> stockCheckpointList) {
        return stockCheckpointList.stream().map(CheckpointFactory::buildDTO).collect(Collectors.toList());
    }

    public static List<CheckpointDTO> buildListRealEstateFundCheckpointDTO(List<RealEstateFundCheckpoint> realEstateFundCheckpointList) {
        return realEstateFundCheckpointList.stream().map(CheckpointFactory::buildDTO).collect(Collectors.toList());
    }

}
