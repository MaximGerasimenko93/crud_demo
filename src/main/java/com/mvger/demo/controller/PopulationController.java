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
    public List<Population> getPopulations() {
        List<Population> allPopulations = populationService.getAllPopulations();
        return allPopulations;
    }

    @GetMapping(path = "/populations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Population getPopulationById(@PathVariable Long id) {
        Population populationById = populationService.getPopulationById(id);
        return populationById;
    }

    @PostMapping(path = "/populations")
    public void createPopulation(@RequestBody Population population) {
        populationService.createPopulation(population);
    }

    @PutMapping(path = "/populations/{id}")
    public void updatePopulation(@PathVariable Long id, @RequestParam Integer number) {
        populationService.updatePopulationById(id, number);
    }

    @DeleteMapping(path = "/populations/{id}")
    public void deletePopulationById(@PathVariable Long id) {
        populationService.deletePopulationById(id);
    }
}
