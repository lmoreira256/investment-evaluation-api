package com.devlucasmoreira.investmentevaluation.server.service.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.Historic;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.HistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.HistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HistoricListService {

    @Autowired
    private HistoricRepository historicRepository;

    public Page<HistoricResponse> execute(Pageable pageable) {
        Page<Historic> historicPage = historicRepository.findAll(pageable);

        return HistoricFactory.buildPageResponse(historicPage);
    }

}
