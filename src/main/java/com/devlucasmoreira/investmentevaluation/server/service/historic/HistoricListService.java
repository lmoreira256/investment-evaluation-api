package com.devlucasmoreira.investmentevaluation.server.service.historic;

import com.devlucasmoreira.investmentevaluation.server.domain.Historic;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.HistoricFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.HistoricResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricListService {

    @Autowired
    private HistoricRepository historicRepository;

    public List<HistoricResponse> execute() {
        List<Historic> historicList = historicRepository.findAll();

        return HistoricFactory.buildResponseList(historicList);
    }

}
