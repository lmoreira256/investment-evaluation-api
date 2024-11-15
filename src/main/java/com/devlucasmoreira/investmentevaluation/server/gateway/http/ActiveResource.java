package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.KeyValueDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.ActiveFactory;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetByIdService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveListService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveUpdateService;
import com.devlucasmoreira.investmentevaluation.server.service.active.GetActivePercentageService;
import com.devlucasmoreira.investmentevaluation.server.service.active.GetPortfolioPercentageService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ListNextActivesToBuyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/active")
public class ActiveResource {

    private final ActiveCreateService activeCreateService;
    private final ActiveListService activeListService;
    private final ActiveUpdateService activeUpdateService;
    private final ActiveGetByIdService activeGetByIdService;
    private final ActiveGetSummaryService activeGetSummaryService;
    private final ListNextActivesToBuyService listNextActivesToBuyService;
    private final GetPortfolioPercentageService getPortfolioPercentageService;
    private final GetActivePercentageService getActivePercentageService;

    ActiveResource(ActiveCreateService activeCreateService,
                   ActiveListService activeListService,
                   ActiveUpdateService activeUpdateService,
                   ActiveGetByIdService activeGetByIdService,
                   ActiveGetSummaryService activeGetSummaryService,
                   ListNextActivesToBuyService listNextActivesToBuyService,
                   GetPortfolioPercentageService getPortfolioPercentageService,
                   GetActivePercentageService getActivePercentageService) {
        this.activeCreateService = activeCreateService;
        this.activeListService = activeListService;
        this.activeUpdateService = activeUpdateService;
        this.activeGetByIdService = activeGetByIdService;
        this.activeGetSummaryService = activeGetSummaryService;
        this.listNextActivesToBuyService = listNextActivesToBuyService;
        this.getPortfolioPercentageService = getPortfolioPercentageService;
        this.getActivePercentageService = getActivePercentageService;
    }

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> create(@Valid @RequestBody ActiveDTO activeDTO) {

        return new ResponseEntity<>(ActiveFactory.buildDTO(activeCreateService.execute(activeDTO)), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> update(@PathVariable("id") UUID id, @RequestBody ActiveDTO activeDTO) {

        return new ResponseEntity<>(ActiveFactory.buildDTO(activeUpdateService.execute(id, activeDTO)), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> get(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(ActiveFactory.buildDTO(activeGetByIdService.execute(id)), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActiveDTO>> list() {

        return new ResponseEntity<>(ActiveFactory.buildListDTO(activeListService.execute()), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveSummaryDTO> summary() {

        return new ResponseEntity<>(activeGetSummaryService.execute(List.of(ActiveTypeEnum.values())), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/actives-to-buy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActiveDTO>> activesToBuy() {

        return new ResponseEntity<>(ActiveFactory.buildListDTO(listNextActivesToBuyService.execute()), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/get-portfolio-percentage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KeyValueDTO>> getPortfolioPercentage() {

        return new ResponseEntity<>(getPortfolioPercentageService.execute(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/get-active-percentage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KeyValueDTO>> getActivePercentage() {

        return new ResponseEntity<>(getActivePercentageService.execute(), HttpStatus.OK);
    }

}
