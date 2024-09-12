package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.KeyValueDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class GetPortfolioPercentageService {

    private final ActiveRepository activeRepository;

    GetPortfolioPercentageService(ActiveRepository activeRepository) {
        this.activeRepository = activeRepository;
    }

    public List<KeyValueDTO> execute() {
        BigDecimal currentValueTotal = activeRepository.sumCurrentValueEnabled();
        BigDecimal stockCurrentValueTotal = activeRepository.sumStockCurrentValueEnabled();
        BigDecimal realEstateFundCurrentValueTotal = activeRepository.sumRealEstateFundCurrentValueEnabled();

        MathContext mc = new MathContext(2);

        return List.of(
                KeyValueDTO.builder()
                        .key("AÇÕES")
                        .value(stockCurrentValueTotal.divide(currentValueTotal, mc).multiply(new BigDecimal(100)))
                        .build(),
                KeyValueDTO.builder()
                        .key("FII")
                        .value(realEstateFundCurrentValueTotal.divide(currentValueTotal, mc).multiply(new BigDecimal(100)))
                        .build()
        );
    }

}
