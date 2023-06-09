package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.view.EarningSummaryActiveView;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EarningSummaryForActiveService {

    @Autowired
    private EarningRepository earningRepository;

    public List<EarningSummaryActiveDTO> execute() {
        List<EarningSummaryActiveView> earningSummaryActiveViews = earningRepository.getEarningSummaryForActive();

        return earningSummaryActiveViews.stream().map(earningSummaryActiveView -> EarningSummaryActiveDTO.builder()
                .active(earningSummaryActiveView.getActive())
                .totalValue(earningSummaryActiveView.getTotalValue())
                .build()).collect(Collectors.toList());
    }

}
