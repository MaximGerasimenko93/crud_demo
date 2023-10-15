package com.mvger.demo.controller;

import com.mvger.demo.model.Continent;
import com.mvger.demo.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping(path = "/continents")
    public List<Continent> getContinents() {
        List<Continent> allContinents = continentService.getAllContinents();
        return allContinents;
    }

    @GetMapping(path = "/continents/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Continent getContinentById(@PathVariable Long id) {
        Continent continentById = continentService.getContinentById(id);
        return continentById;
    }

    @PostMapping(path = "/continents")
    public void createContinent(@RequestBody Continent continent) {
        continentService.addContinent(continent);
    }

    @PutMapping(path = "/continents/{id}")
    public void updateContinent(@PathVariable Long id, @RequestParam String name) {
        continentService.updateContinentById(id, name);
    }

    @DeleteMapping(path = "/continents/{id}")
    public void deleteContinentById(@PathVariable Long id) {
        continentService.deleteContinentById(id);
    }
}

