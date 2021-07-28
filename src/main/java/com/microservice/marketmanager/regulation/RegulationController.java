/*
package com.microservice.marketmanager.regulation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/regulations")
public class RegulationController {

    private final RegulationService regulationService;

    public RegulationController(RegulationService regulationService) {
        this.regulationService = regulationService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Regulation>> findRegulations (@PathVariable("id") Iterable<Long> id) {
        var regulations = this.regulationService.regulationsById(id);
        return new ResponseEntity <List<Regulation>>(regulations, HttpStatus.OK);
    }
}
*/
