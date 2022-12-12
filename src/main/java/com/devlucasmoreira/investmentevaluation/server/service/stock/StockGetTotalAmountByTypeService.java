package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockGetTotalAmountByTypeService {

    @Autowired
    private StockRepository stockRepository;

    public Integer execute(StockTypeEnum stockTypeEnum) {
        return stockRepository.getTotalAmountByType(stockTypeEnum);
    }

}
