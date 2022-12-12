package com.devlucasmoreira.investmentevaluation.server.service.stock.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.StockHistoric;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.StockHistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.StockHistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.StockHistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockHistoricListService {

    @Autowired
    private StockHistoricRepository stockHistoricRepository;

    public Page<StockHistoricResponse> execute(Pageable pageable) {
        Page<StockHistoric> stockHistoricPage = stockHistoricRepository.findAll(pageable);

        return StockHistoricFactory.buildPageResponse(stockHistoricPage);
    }

}
