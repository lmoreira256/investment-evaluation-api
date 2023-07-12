package com.devlucasmoreira.investmentevaluation.server.service.checkpoint;

import com.devlucasmoreira.investmentevaluation.server.domain.Checkpoint;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.CheckpointRepository;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CheckpointCreateService {

    @Autowired
    private CheckpointRepository checkpointRepository;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private ActiveGetSummaryService activeGetSummaryService;

    public Checkpoint execute() {
        ActiveSummaryDTO activeSummaryDTO = activeGetSummaryService
                .execute(List.of(ActiveTypeEnum.REAL_ESTATE_FUND, ActiveTypeEnum.STOCK));

        Checkpoint checkpoint = Checkpoint.builder()
                .amount(activeSummaryDTO.getAmount())
                .currentValue(activeSummaryDTO.getCurrentValue())
                .purchaseValue(activeSummaryDTO.getPurchaseValue())
                .resultValue(activeSummaryDTO.getResultValue())
                .resultPercentageValue(activeSummaryDTO.getResultPercentageValue())
                .build();

        Objects.requireNonNull(cacheManager.getCache("checkpointList")).clear();
        return checkpointRepository.save(checkpoint);
    }

}
