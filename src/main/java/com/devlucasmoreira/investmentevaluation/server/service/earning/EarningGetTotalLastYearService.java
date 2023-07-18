package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EarningGetTotalLastYearService {

    @Autowired
    private EarningRepository earningRepository;

    public BigDecimal execute() {

        return earningRepository.getTotalLastYear();
    }

}
