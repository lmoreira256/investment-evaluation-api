package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveGetSummaryService {

    @Autowired
    private ActiveRepository activeRepository;

    public ActiveSummaryDTO execute(List<ActiveTypeEnum> activeTypeEnumList) {
        return ActiveSummaryDTO.builder()
                .amount(activeRepository.getTotalAmountByType(activeTypeEnumList))
                .currentValue(activeRepository.getTotalCurrentValueByType(activeTypeEnumList))
                .purchaseValue(activeRepository.getTotalPurchaseValueByType(activeTypeEnumList))
                .resultValue(activeRepository.getTotalResultValueByType(activeTypeEnumList))
                .resultPercentageValue(activeRepository.getTotalResulPercentageValueByType(activeTypeEnumList))
                .build();
    }

}
