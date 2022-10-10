package com.devlucasmoreira.investmentevaluation.server.service.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.Historic;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.HistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.HistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.CoinRepository;
import com.devlucasmoreira.investmentevaluation.server.repository.DepositRepository;
import com.devlucasmoreira.investmentevaluation.server.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.OffsetDateTime;
import java.util.Objects;

@Service
public class HistoricCreateService {

    @Autowired
    private HistoricRepository historicRepository;

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private CacheManager cacheManager;

    public HistoricResponse execute() {
        BigDecimal totalCurrentValue = coinRepository.getTotalCurrentValue();
        BigDecimal totalAmount = coinRepository.getTotalAmount();
        BigDecimal totalValueDeposit = depositRepository.getTotalValue();
        BigDecimal cashReturn = totalCurrentValue.subtract(totalValueDeposit);
        MathContext mc = new MathContext(3);

        Historic historic = Historic.builder()
                .amount(totalAmount)
                .value(totalCurrentValue)
                .cashReturn(cashReturn)
                .profitability(cashReturn.multiply(new BigDecimal(100)).divide(totalValueDeposit, mc))
                .date(OffsetDateTime.now())
                .build();

        historicRepository.save(historic);

        Objects.requireNonNull(cacheManager.getCache("historicList")).clear();
        return HistoricFactory.buildResponse(historic);
    }

}
