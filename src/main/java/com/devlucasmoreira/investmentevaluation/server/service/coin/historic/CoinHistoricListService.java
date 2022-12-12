package com.devlucasmoreira.investmentevaluation.server.service.coin.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.CoinHistoric;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CoinHistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.CoinHistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoinHistoricListService {

    @Autowired
    private HistoricRepository historicRepository;

    public Page<CoinHistoricResponse> execute(Pageable pageable) {
        Page<CoinHistoric> coinHistoricPage = historicRepository.findAll(pageable);

        return CoinHistoricFactory.buildPageResponse(coinHistoricPage);
    }

}
