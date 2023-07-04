package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockGetStockSummaryService {

    @Autowired
    private StockRepository stockRepository;

    public ActiveSummaryDTO execute() {
        return ActiveSummaryDTO.builder()
                .amount(stockRepository.getTotalAmountByType(List.of(StockTypeEnum.STOCK)))
                .currentValue(stockRepository.getTotalCurrentValueByType(List.of(StockTypeEnum.STOCK)))
                .purchaseValue(stockRepository.getTotalPurchaseValueByType(List.of(StockTypeEnum.STOCK)))
                .build();
    }

}
