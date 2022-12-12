package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.enums.StockTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockGetTotalAmountByTypeService {

    @Autowired
    private StockRepository stockRepository;

    public Integer execute(List<StockTypeEnum> stockTypeEnumList) {
        return stockRepository.getTotalAmountByType(stockTypeEnumList);
    }

}
