package com.mvger.demo.controller;


import com.mvger.demo.model.Animal;
import com.mvger.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping(path = "/animals")
    public List<Animal> getAnimals() {
        List<Animal> allAnimals = animalService.getAllAnimals();
        return allAnimals;
    }

    @GetMapping(path = "/animals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal getAnimalById(@PathVariable Long id) {
        Animal animalById = animalService.getAnimalById(id);
        return animalById;
    }

    @PostMapping(path = "/animals")
    public void createAnimal(@RequestBody Animal animal) {
        animalService.createAnimal(animal);
    }

    @PutMapping(path = "/animals/{id}")
    public void updateAnimal(@PathVariable Long id, @RequestParam String name) {
        animalService.updateAnimalNameById(id, name);
    }

    @DeleteMapping(path = "/animals/{id}")
    public void deleteAnimalById(@PathVariable Long id) {
        animalService.deleteAnimalById(id);
    }
}
