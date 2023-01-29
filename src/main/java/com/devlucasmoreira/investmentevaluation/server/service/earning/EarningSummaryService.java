package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.EarningFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningMonthSummaryResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningStockSummaryResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningSummaryResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class EarningSummaryService {

    @Autowired
    private EarningRepository earningRepository;

    public EarningSummaryResponse execute() {
        List<Earning> earningList = earningRepository.findAllByOrderByCreatedAtDesc();

        EarningSummaryResponse earningSummaryResponse = EarningSummaryResponse.builder()
                .earningMonthSummary(new ArrayList<>())
                .earningStockSummary(new ArrayList<>())
                .totalValue(earningRepository.getTotalValue())
                .build();

        mountResponse(earningList, earningSummaryResponse);

        return earningSummaryResponse;
    }

    private void mountResponse(List<Earning> earningList, EarningSummaryResponse earningSummaryResponse) {
        earningList.forEach(earning -> {
            mountEarningStockSummary(earning, earningSummaryResponse);
            mountEarningMonthSummary(earning, earningSummaryResponse);
        });
    }

    private void mountEarningStockSummary(Earning earning, EarningSummaryResponse earningSummaryResponse) {
        String active = earning.getStock().getActive();

        if (earningSummaryResponse.getEarningStockSummary().isEmpty()) {
            newEarningStockSummary(active, earning.getAmountPaid(), earningSummaryResponse);
        } else {
            EarningStockSummaryResponse earningStockSummaryResponse = earningSummaryResponse.getEarningStockSummary()
                    .stream().filter(x -> x.getActive().equals(active)).findFirst().orElse(null);

            if (earningStockSummaryResponse == null) {
                newEarningStockSummary(active, earning.getAmountPaid(), earningSummaryResponse);
            } else {
                earningStockSummaryResponse.setTotalValue(earningStockSummaryResponse.getTotalValue().add(earning.getAmountPaid()));
            }
        }
    }

    private void newEarningStockSummary(String active, BigDecimal value, EarningSummaryResponse earningSummaryResponse) {
        EarningStockSummaryResponse earningStockSummaryResponse = EarningFactory.buildStockSummaryResponse(active, value);
        earningSummaryResponse.getEarningStockSummary().add(earningStockSummaryResponse);
    }

    private void mountEarningMonthSummary(Earning earning, EarningSummaryResponse earningSummaryResponse) {
        String month = mountMouth(earning.getCreatedAt());

        if (earningSummaryResponse.getEarningStockSummary().isEmpty()) {
            newEarningMonthSummary(month, earning.getAmountPaid(), earningSummaryResponse);
        } else {
            EarningMonthSummaryResponse earningMonthSummaryResponse = earningSummaryResponse.getEarningMonthSummary()
                    .stream().filter(x -> x.getMonth().equals(month)).findFirst().orElse(null);

            if (earningMonthSummaryResponse == null) {
                newEarningMonthSummary(month, earning.getAmountPaid(), earningSummaryResponse);
            } else {
                earningMonthSummaryResponse.setTotalValue(earningMonthSummaryResponse.getTotalValue().add(earning.getAmountPaid()));
            }
        }
    }

    private void newEarningMonthSummary(String month, BigDecimal value, EarningSummaryResponse earningSummaryResponse) {
        EarningMonthSummaryResponse earningMonthSummaryResponse = EarningFactory.buildMonthSummaryResponse(month, value);
        earningSummaryResponse.getEarningMonthSummary().add(earningMonthSummaryResponse);
    }

    private String mountMouth(LocalDateTime localDate) {
        String monthDescription = localDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        return StringUtils.capitalize(monthDescription).concat("/").concat(String.valueOf(localDate.getYear()));
    }

}
