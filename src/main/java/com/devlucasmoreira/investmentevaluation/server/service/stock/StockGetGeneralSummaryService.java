package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockGetGeneralSummaryService {

    @Autowired
    private StockRepository stockRepository;

    public ActiveSummaryDTO execute() {
        return ActiveSummaryDTO.builder()
                .amount(stockRepository.getTotalAmount())
                .currentValue(stockRepository.getTotalCurrentValue())
                .purchaseValue(stockRepository.getTotalPurchaseValue())
                .build();
    }

}
