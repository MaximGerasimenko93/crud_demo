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
    public ResponseEntity<?> getContinents() {
        List<Continent> allContinents = continentService.getAllContinents();
        return new ResponseEntity<>(allContinents, HttpStatus.OK);
    }

    @GetMapping(path = "/continents/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getContinentById(@PathVariable Long id) {
        Continent continentById = continentService.getContinentById(id);
        return new ResponseEntity<>(continentById, HttpStatus.OK);
    }

    @PostMapping(path = "/continents")
    public ResponseEntity<?> createContinent(@RequestBody Continent continent) {
        continentService.addContinent(continent);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/continents/{id}")
    public ResponseEntity<?> updateContinent(@PathVariable Long id,
                                          @RequestParam String name) {
        continentService.updateContinentById(id, name);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/continents/{id}")
    public ResponseEntity<?> deleteContinentById(@PathVariable Long id) {
        continentService.deleteContinentById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

