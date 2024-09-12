package com.devlucasmoreira.investmentevaluation.server.service.active;

import com.devlucasmoreira.investmentevaluation.server.domain.Active;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.KeyValueDTO;
import com.devlucasmoreira.investmentevaluation.server.repository.ActiveRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetActivePercentageService {

    private final ActiveRepository activeRepository;

    GetActivePercentageService(ActiveRepository activeRepository) {
        this.activeRepository = activeRepository;
    }

    public List<KeyValueDTO> execute() {
        MathContext mc = new MathContext(2);

        List<Active> activeList = activeRepository.listEnabled();
        BigDecimal currentValueTotal = activeRepository.sumCurrentValueEnabled();

        return activeList.stream()
                .map(x -> KeyValueDTO.builder()
                        .key(x.getName())
                        .value(x.getCurrentValue().divide(currentValueTotal, mc).multiply(new BigDecimal(100)))
                        .build())
                .collect(Collectors.toList());
    }

}
