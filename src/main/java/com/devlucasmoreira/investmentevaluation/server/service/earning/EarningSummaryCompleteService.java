package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.EarningSummaryCompleteDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class EarningSummaryCompleteService {

    @Autowired
    private EarningSummaryTotalService earningSummaryTotalService;

    @Autowired
    private EarningGetTotalLastMonthService earningGetTotalLastMonthService;

    @Autowired
    private EarningGetTotalLastYearService earningGetTotalLastYearService;

    @Autowired
    private ActiveGetSummaryService activeGetSummaryService;

    public EarningSummaryCompleteDTO execute() {
        ActiveSummaryDTO activeSummaryDTO = activeGetSummaryService
                .execute(List.of(ActiveTypeEnum.REAL_ESTATE_FUND, ActiveTypeEnum.STOCK));

        BigDecimal purchaseValue = activeSummaryDTO.getPurchaseValue();
        BigDecimal totalReceived = earningSummaryTotalService.execute();
        BigDecimal performancePercentage = totalReceived.divide(purchaseValue, 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(100));

        return EarningSummaryCompleteDTO.builder()
                .totalReceived(totalReceived)
                .totalLastMonth(earningGetTotalLastMonthService.execute())
                .totalLastYear(earningGetTotalLastYearService.execute())
                .performancePercentage(performancePercentage)
                .build();
    }

}
