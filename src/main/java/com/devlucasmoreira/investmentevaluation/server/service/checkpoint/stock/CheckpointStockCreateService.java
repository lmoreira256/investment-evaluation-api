package com.devlucasmoreira.investmentevaluation.server.service.checkpoint.stock;

import com.devlucasmoreira.investmentevaluation.server.domain.StockCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.StockCheckpointRepository;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointStockCreateService {

    @Autowired
    private StockCheckpointRepository stockCheckpointRepository;

    @Autowired
    private ActiveGetSummaryService activeGetSummaryService;

    public StockCheckpoint execute() {
        ActiveSummaryDTO activeSummaryDTO = activeGetSummaryService.execute(List.of(ActiveTypeEnum.STOCK));

        StockCheckpoint stockCheckpoint = StockCheckpoint.builder()
                .amount(activeSummaryDTO.getAmount())
                .currentValue(activeSummaryDTO.getCurrentValue())
                .purchaseValue(activeSummaryDTO.getPurchaseValue())
                .resultValue(activeSummaryDTO.getResultValue())
                .resultPercentageValue(activeSummaryDTO.getResultPercentageValue())
                .build();

        return stockCheckpointRepository.save(stockCheckpoint);
    }

}
