package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StockGetTotalPurchaseValueByTypeService {

    @Autowired
    private ActiveRepository stockRepository;

    public BigDecimal execute(List<ActiveTypeEnum> stockTypeEnumList) {
        return stockRepository.getTotalPurchaseValueByType(stockTypeEnumList);
    }

}
