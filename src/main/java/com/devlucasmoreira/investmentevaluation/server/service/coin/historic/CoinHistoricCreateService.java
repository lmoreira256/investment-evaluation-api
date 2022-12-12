package com.devlucasmoreira.investmentevaluation.server.service.coin.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.CoinHistoric;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CoinHistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinHistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.CoinRepository;
import com.devlucasmoreira.investmentevaluation.server.repository.HistoricRepository;
import com.devlucasmoreira.investmentevaluation.server.service.deposit.DepositGetTotalValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class CoinHistoricCreateService {

    @Autowired
    private HistoricRepository historicRepository;

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private DepositGetTotalValueService depositGetTotalValueService;

    @Autowired
    private CacheManager cacheManager;

    public CoinHistoricResponse execute() {
        BigDecimal actualValue = coinRepository.getActualValue();
        BigDecimal amount = coinRepository.getAmount();
        BigDecimal totalValueDeposit = depositGetTotalValueService.execute();
        BigDecimal cashReturn = actualValue.subtract(totalValueDeposit);

        CoinHistoric coinHistoric = CoinHistoricFactory.build(amount, actualValue, cashReturn, totalValueDeposit);

        historicRepository.save(coinHistoric);

        Objects.requireNonNull(cacheManager.getCache("coinHistoricList")).clear();
        return CoinHistoricFactory.buildResponse(coinHistoric);
    }

}
