package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.ActiveFactory;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveListByTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/real-estate-fund")
public class RealEstateFundResource {

    @Autowired
    private ActiveListByTypeService activeListByTypeService;

    @Autowired
    private ActiveGetSummaryService activeGetSummaryService;

    @CrossOrigin
    @Cacheable(value = "realEstateFundList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActiveDTO>> list() {

        return new ResponseEntity<>(ActiveFactory.buildListDTO(
                activeListByTypeService.execute(ActiveTypeEnum.REAL_ESTATE_FUND)), HttpStatus.OK);
    }


    @CrossOrigin
    @Cacheable(value = "realEstateFundSummary")
    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveSummaryDTO> summary() {

        return new ResponseEntity<>(activeGetSummaryService
                .execute(List.of(ActiveTypeEnum.REAL_ESTATE_FUND)), HttpStatus.OK);
    }


}
