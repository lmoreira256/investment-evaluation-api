package com.devlucasmoreira.investmentevaluation.server.service.deposit;

import com.devlucasmoreira.investmentevaluation.server.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepositGetTotalValueService {

    @Autowired
    private DepositRepository depositRepository;

    public BigDecimal execute() {
        return depositRepository.getTotalValue();
    }

}
