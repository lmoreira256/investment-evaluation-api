package com.devlucasmoreira.investmentevaluation.server.service.stock.checkpoint;

import com.devlucasmoreira.investmentevaluation.server.domain.StockCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.StockCheckpointRepository;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StockCheckpointCreateService {

    @Autowired
    private StockCheckpointRepository stockCheckpointRepository;

    @Autowired
    private CacheManager cacheManager;

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

        Objects.requireNonNull(cacheManager.getCache("stockCheckpointList")).clear();
        return stockCheckpointRepository.save(stockCheckpoint);
    }

}
