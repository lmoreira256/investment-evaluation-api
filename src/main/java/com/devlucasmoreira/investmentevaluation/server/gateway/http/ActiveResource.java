package com.devlucasmoreira.investmentevaluation.server.gateway.http;

import com.devlucasmoreira.investmentevaluation.server.enums.ActiveTypeEnum;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.ActiveSummaryDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.dto.active.ActiveDTO;
import com.devlucasmoreira.investmentevaluation.server.gateway.model.factory.ActiveFactory;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveCreateService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetByIdService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveGetSummaryService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveListService;
import com.devlucasmoreira.investmentevaluation.server.service.active.ActiveUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/active")
public class ActiveResource {

    @Autowired
    private ActiveCreateService activeCreateService;

    @Autowired
    private ActiveListService activeListService;

    @Autowired
    private ActiveUpdateService activeUpdateService;

    @Autowired
    private ActiveGetByIdService activeGetByIdService;

    @Autowired
    private ActiveGetSummaryService activeGetSummaryService;

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> create(@RequestBody ActiveDTO activeDTO) {

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
    @Cacheable(value = "activeList")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActiveDTO>> list() {

        return new ResponseEntity<>(ActiveFactory.buildListDTO(activeListService.execute()), HttpStatus.OK);
    }

    @CrossOrigin
    @Cacheable(value = "activeSummary")
    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveSummaryDTO> summary() {

        return new ResponseEntity<>(activeGetSummaryService.execute(List.of(ActiveTypeEnum.values())), HttpStatus.OK);
    }

}
