package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class EarningGetAveragePerMonthService {

    @Autowired
    private EarningRepository earningRepository;

    public BigDecimal execute() {

        return Optional.ofNullable(earningRepository.getAveragePerMonth()).orElse(BigDecimal.ZERO);
    }

}