package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.EarningFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EarningListService {

    @Autowired
    private EarningRepository earningRepository;

    public Page<EarningResponse> execute(String active, Pageable pageable) {
        Page<Earning> earningPage = active == null || active.length() == 0
                ? earningRepository.findAll(pageable) : earningRepository.findByActive(active.toUpperCase(), pageable);

        return EarningFactory.buildPageResponse(earningPage);
    }

}
