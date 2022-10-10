package com.devlucasmoreira.investmentevaluation.server.service.deposit;

import com.devlucasmoreira.investmentevaluation.server.domain.Deposit;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.DepositFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.DepositResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepositListService {

    @Autowired
    private DepositRepository depositRepository;

    public Page<DepositResponse> execute(Pageable pageable) {
        Page<Deposit> depositPage = depositRepository.findAll(pageable);

        return DepositFactory.buildPageResponse(depositPage);
    }

}
