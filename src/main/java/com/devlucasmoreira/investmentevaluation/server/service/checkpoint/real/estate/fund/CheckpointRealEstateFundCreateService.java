package com.devlucasmoreira.investmentevaluation.server.service.checkpoint.real.estate.fund;

import com.devlucasmoreira.investmentevaluation.server.domain.RealEstateFundCheckpoint;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.RealEstateFundCheckpointRepository;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointRealEstateFundCreateService {

    @Autowired
    private RealEstateFundCheckpointRepository realEstateFundCheckpointRepository;

    @Autowired
    private ActiveGetSummaryService activeGetSummaryService;

    public RealEstateFundCheckpoint execute() {
        ActiveSummaryDTO activeSummaryDTO = activeGetSummaryService.execute(List.of(ActiveTypeEnum.REAL_ESTATE_FUND));

        RealEstateFundCheckpoint realEstateFundCheckpoint = RealEstateFundCheckpoint.builder()
                .amount(activeSummaryDTO.getAmount())
                .currentValue(activeSummaryDTO.getCurrentValue())
                .purchaseValue(activeSummaryDTO.getPurchaseValue())
                .resultValue(activeSummaryDTO.getResultValue())
                .resultPercentageValue(activeSummaryDTO.getResultPercentageValue())
                .build();

        return realEstateFundCheckpointRepository.save(realEstateFundCheckpoint);
    }

}
