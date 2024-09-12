package com.devlucasmoreira.investmentevaluation.server.service.coin.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.CoinHistoric;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CoinHistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinHistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.CoinHistoricRepository;
import com.devlucasmoreira.investmentevaluation.server.repository.CoinRepository;
import com.devlucasmoreira.investmentevaluation.server.service.deposit.DepositGetTotalValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CoinHistoricCreateService {

    @Autowired
    private CoinHistoricRepository coinHistoricRepository;

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private DepositGetTotalValueService depositGetTotalValueService;

    public CoinHistoricResponse execute() {
        BigDecimal actualValue = coinRepository.getActualValue();
        BigDecimal amount = coinRepository.getAmount();
        BigDecimal totalValueDeposit = depositGetTotalValueService.execute();
        BigDecimal cashReturn = actualValue.subtract(totalValueDeposit);

        CoinHistoric coinHistoric = CoinHistoricFactory.build(amount, actualValue, cashReturn, totalValueDeposit);

        coinHistoricRepository.save(coinHistoric);

        return CoinHistoricFactory.buildResponse(coinHistoric);
    }

}
