package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.view.EarningSummaryView;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EarningSummaryForMonthService {

    private final static String SORT_DIRECTION_ASC = "ASC";

    @Autowired
    private EarningRepository earningRepository;

    public List<EarningSummaryDTO> execute(String month, String sortDirection) {
        sortDirection = Objects.nonNull(sortDirection) ? sortDirection : SORT_DIRECTION_ASC;

        List<EarningSummaryView> earningSummaryViewList = Strings.isBlank(month) ?
                earningRepository.getEarningSummaryForMonth(sortDirection) :
                earningRepository.getEarningSummaryByMonth(month);

        return earningSummaryViewList.stream().map(earningSummaryView -> EarningSummaryDTO.builder()
                .item(earningSummaryView.getItem())
                .totalValue(earningSummaryView.getTotalValue())
                .build()).collect(Collectors.toList());
    }

}
