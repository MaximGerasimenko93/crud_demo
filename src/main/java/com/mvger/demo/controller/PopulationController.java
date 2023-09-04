package com.mvger.demo.controller;

import com.mvger.demo.model.Population;
import com.mvger.demo.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PopulationController {

    @Autowired
    PopulationService populationService;

    @GetMapping(path = "/populations")
    public ResponseEntity<?> getPopulations() {
        List<Population> allPopulations = populationService.getAllPopulations();
        return new ResponseEntity<>(allPopulations, HttpStatus.OK);
    }

    @GetMapping(path = "/populations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPopulationById(@PathVariable Long id) {
        Population populationById = populationService.getPopulationById(id);
        return new ResponseEntity<>(populationById, HttpStatus.OK);
    }

    @PostMapping(path = "/populations")
    public ResponseEntity<?> createPopulation(@RequestBody Population population) {
        populationService.createPopulation(population);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/populations/{id}")
    public ResponseEntity<?> updatePopulation(@PathVariable Long id,
                                             @RequestParam Integer number) {
        populationService.updatePopulationById(id, number);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/populations/{id}")
    public ResponseEntity<?> deletePopulationById(@PathVariable Long id) {
        populationService.deletePopulationById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
