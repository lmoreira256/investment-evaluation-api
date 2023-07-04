package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.exception.ActiveNotFoundException;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveGetByNameService {

    @Autowired
    private ActiveRepository activeRepository;

    public Active execute(String name) {
        return activeRepository.findByName(name.toUpperCase())
                .orElseThrow(ActiveNotFoundException::new);
    }

}
