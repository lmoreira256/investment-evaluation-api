package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.EarningFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarningListService {

    @Autowired
    private EarningRepository earningRepository;

    public List<EarningResponse> execute(String active) {
        List<Earning> earningList = active == null || active.length() == 0
                ? earningRepository.findTop30ByOrderByCreatedAtDesc() : earningRepository.findByActive(active.toUpperCase());

        return EarningFactory.buildListResponse(earningList);
    }

}
