package com.devlucasmoreira.investmentevaluation.server.service.deposit;

import com.devlucasmoreira.investmentevaluation.server.domain.Deposit;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.DepositFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.DepositRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.DepositResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositCreateService {

    @Autowired
    private DepositRepository depositRepository;

    public DepositResponse execute(DepositRequest depositRequest) {
        Deposit deposit = DepositFactory.build(depositRequest);

        return DepositFactory.buildResponse(depositRepository.save(deposit));
    }

}
