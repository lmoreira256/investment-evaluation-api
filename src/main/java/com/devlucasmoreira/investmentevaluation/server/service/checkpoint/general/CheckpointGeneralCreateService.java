package com.devlucasmoreira.investmentevaluation.server.service.checkpoint.general;

import com.devlucasmoreira.investmentevaluation.server.domain.Checkpoint;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.CheckpointRepository;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointGeneralCreateService {

    @Autowired
    private ActiveGetSummaryService activeGetSummaryService;

    @Autowired
    private CheckpointRepository checkpointRepository;

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

        return checkpointRepository.save(checkpoint);
    }

}
