package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;

import java.util.List;
import java.util.stream.Collectors;

public class EarningFactory {

    public static Earning build(EarningRequest earningRequest, Active active) {
        return Earning.builder()
                .payday(earningRequest.getPayday())
                .amountPaid(earningRequest.getAmountPaid())
                .description(earningRequest.getDescription())
                .active(active)
                .build();
    }

    public static EarningResponse buildResponse(Earning earning) {
        return EarningResponse.builder()
                .payday(earning.getPayday())
                .amountPaid(earning.getAmountPaid())
                .description(earning.getDescription())
                .id(earning.getId())
                .activeName(earning.getActive().getName())
                .build();
    }

    public static List<EarningResponse> buildListResponse(List<Earning> earningList) {
        return earningList.stream().map(EarningFactory::buildResponse).collect(Collectors.toList());
    }

}
