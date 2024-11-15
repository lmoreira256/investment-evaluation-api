package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.exception.ActiveAlreadyExistsException;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.ActiveFactory;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveCreateService {

    @Autowired
    private ActiveRepository activeRepository;

    public Active execute(ActiveDTO activeDTO) {
        validateActive(activeDTO);

        return activeRepository.save(ActiveFactory.build(activeDTO));
    }

    private void validateActive(ActiveDTO activeDTO) {
        if (activeRepository.existsByName(activeDTO.getName())) {
            throw new ActiveAlreadyExistsException();
        }
    }

}
