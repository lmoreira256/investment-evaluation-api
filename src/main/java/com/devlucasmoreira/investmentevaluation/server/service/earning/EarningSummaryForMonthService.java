package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.view.EarningSummaryView;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EarningSummaryForMonthService {

    @Autowired
    private EarningRepository earningRepository;

    public List<EarningSummaryDTO> execute() {
        List<EarningSummaryView> earningSummaryViewList = earningRepository.getEarningSummaryForMonth();

        return earningSummaryViewList.stream().map(earningSummaryView -> EarningSummaryDTO.builder()
                .item(earningSummaryView.getItem())
                .totalValue(earningSummaryView.getTotalValue())
                .build()).collect(Collectors.toList());
    }

}
