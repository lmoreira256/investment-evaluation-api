package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.view.EarningSummaryView;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EarningSummaryForActiveService {

    @Autowired
    private EarningRepository earningRepository;

    public List<EarningSummaryDTO> execute(String active) {
        Pageable topTwenty = PageRequest.of(0, 10);

        List<EarningSummaryView> earningSummaryViewList = Strings.isBlank(active) ?
                earningRepository.getEarningSummaryForActive(topTwenty)
                : earningRepository.getEarningSummaryByActive(active);

        return earningSummaryViewList.stream().map(earningSummaryView -> EarningSummaryDTO.builder()
                .item(earningSummaryView.getItem())
                .totalValue(earningSummaryView.getTotalValue())
                .build()).collect(Collectors.toList());
    }

}
