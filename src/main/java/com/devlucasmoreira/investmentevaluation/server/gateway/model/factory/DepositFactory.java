package com.devlucasmoreira.investmentevaluation.server.gateway.model.factory;

import com.devlucasmoreira.investmentevaluation.server.domain.Deposit;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.DepositRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.DepositResponse;
import org.springframework.data.domain.Page;

import java.time.OffsetDateTime;

public class DepositFactory {

    public static Deposit build(DepositRequest depositRequest) {
        return Deposit.builder()
                .date(depositRequest.getDate() == null ? OffsetDateTime.now() : depositRequest.getDate())
                .value(depositRequest.getValue())
                .build();
    }

    public static DepositResponse buildResponse(Deposit deposit) {
        return DepositResponse.builder()
                .date(deposit.getDate())
                .value(deposit.getValue())
                .build();
    }

    public static Page<DepositResponse> buildPageResponse(Page<Deposit> depositPage) {
        return depositPage.map(DepositFactory::buildResponse);
    }

}
