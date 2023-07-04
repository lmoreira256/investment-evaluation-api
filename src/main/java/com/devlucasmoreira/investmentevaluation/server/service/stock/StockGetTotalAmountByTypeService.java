package com.devlucasmoreira.investmentevaluation.server.service.stock;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockGetTotalAmountByTypeService {

    @Autowired
    private ActiveRepository stockRepository;

    public Integer execute(List<ActiveTypeEnum> stockTypeEnumList) {
        return stockRepository.getTotalAmountByType(stockTypeEnumList);
    }

}
