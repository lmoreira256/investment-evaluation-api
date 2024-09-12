package com.devlucasmoreira.investmentevaluation.server.service.checkpoint;

import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.CheckpointDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.CheckpointFactory;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.general.CheckpointGeneralCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.real.estate.fund.CheckpointRealEstateFundCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.checkpoint.stock.CheckpointStockCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointCreateService {

    @Autowired
    private CheckpointGeneralCreateService checkpointGeneralCreateService;

    @Autowired
    private CheckpointStockCreateService checkpointStockCreateService;

    @Autowired
    private CheckpointRealEstateFundCreateService checkpointRealEstateFundCreateService;

    public List<CheckpointDTO> execute() {
        return List.of(
                CheckpointFactory.buildDTO(checkpointGeneralCreateService.execute()),
                CheckpointFactory.buildDTO(checkpointStockCreateService.execute()),
                CheckpointFactory.buildDTO(checkpointRealEstateFundCreateService.execute())
        );
    }

}
