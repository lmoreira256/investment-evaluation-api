package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActiveUpdateService {

    @Autowired
    private ActiveRepository stockRepository;

    @Autowired
    private ActiveGetByIdService activeGetByIdService;

    public Active execute(UUID id, ActiveDTO activeDTO) {
        Active active = activeGetByIdService.execute(id);
        active.setQuantity(activeDTO.getQuantity());
        active.setDescription(activeDTO.getDescription());
        active.setCurrentValue(activeDTO.getCurrentValue());
        active.setCostValue(activeDTO.getCostValue());
        active.setAverageCost(activeDTO.getAverageCost());
        active.setNetResult(activeDTO.getNetResult());
        active.setPercentageResult(activeDTO.getPercentageResult());
        active.setObjective(activeDTO.getObjective());
        active.setEnabled(activeDTO.getEnabled());
        active.setCurrentPrice(activeDTO.getCurrentPrice());

        return stockRepository.save(active);
    }

}
