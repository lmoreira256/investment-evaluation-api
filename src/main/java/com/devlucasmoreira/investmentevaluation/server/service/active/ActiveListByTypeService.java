package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveListByTypeService {

    @Autowired
    private ActiveRepository activeRepository;

    public List<Active> execute(ActiveTypeEnum activeTypeEnum) {
        return activeRepository.listActiveByType(activeTypeEnum);
    }

}
