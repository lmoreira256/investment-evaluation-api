package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ActiveUpdateService {

    @Autowired
    private ActiveRepository stockRepository;

    @Autowired
    private ActiveCleanCacheService activeCleanCacheService;

    @Autowired
    private ActiveGetByIdService activeGetByIdService;

    public Active execute(UUID id, ActiveDTO activeDTO) {
        Active active = activeGetByIdService.execute(id);
        active.setAmount(activeDTO.getAmount());
        active.setDescription(activeDTO.getDescription());
        active.setCurrentValue(activeDTO.getCurrentValue());
        active.setPurchaseValue(activeDTO.getPurchaseValue());
        active.setAverageValue(activeDTO.getAverageValue());
        active.setResultValue(activeDTO.getResultValue());
        active.setResultPercentageValue(activeDTO.getResultPercentageValue());
        active.setObjective(activeDTO.getObjective());
        active.setEnabled(activeDTO.getEnabled());
        active.setActualValue(activeDTO.getActualValue());

        activeCleanCacheService.execute();
        return stockRepository.save(active);
    }

}
