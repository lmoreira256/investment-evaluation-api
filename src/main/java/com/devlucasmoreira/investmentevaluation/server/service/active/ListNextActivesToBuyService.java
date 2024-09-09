package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListNextActivesToBuyService {

    private final ActiveRepository activeRepository;

    ListNextActivesToBuyService(ActiveRepository activeRepository) {
        this.activeRepository = activeRepository;
    }

    public List<Active> execute() {
        return activeRepository.listActivesToBuy();
    }

}
