package com.devlucasmoreira.investmentevaluation.server.service.earning;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.domain.Earning;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.EarningFactory;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.request.EarningRequest;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.response.EarningResponse;
import com.devlucasmoreira.investmentevaluation.server.repository.EarningRepository;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarningCreateService {

    @Autowired
    private ActiveGetByIdService activeGetByIdService;

    @Autowired
    private EarningRepository earningRepository;

    public EarningResponse execute(EarningRequest earningRequest) {
        Active active = activeGetByIdService.execute(earningRequest.getActiveId());
        Earning earning = EarningFactory.build(earningRequest, active);

        return EarningFactory.buildResponse(earningRepository.save(earning));
    }

}
