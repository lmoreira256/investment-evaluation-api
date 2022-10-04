package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Coin;
import com.devlucasmoreira.investmentevaluation.server.domain.Historic;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinResponse;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.HistoricResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class HistoricFactory {

    public static List<HistoricResponse> buildResponseList(List<Historic> historicList) {
        return historicList.stream().map(HistoricFactory::buildResponse).collect(Collectors.toList());
    }

    public static HistoricResponse buildResponse(Historic historic) {
        return HistoricResponse.builder()
                .amount(historic.getAmount())
                .cashReturn(historic.getCashReturn())
                .date(historic.getDate())
                .profitability(historic.getProfitability())
                .value(historic.getValue())
                .build();
    }

    public static Page<HistoricResponse> buildPageResponse(Page<Historic> historicPage) {
        return historicPage.map(HistoricFactory::buildResponse);
    }


}
