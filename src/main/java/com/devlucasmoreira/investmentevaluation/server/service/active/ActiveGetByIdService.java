package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.exception.ActiveNotFoundException;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActiveGetByIdService {

    @Autowired
    private ActiveRepository activeRepository;

    public Active execute(UUID id) {
        return activeRepository.findById(id).orElseThrow(ActiveNotFoundException::new);
    }

}
