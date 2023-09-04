package com.mvger.demo.controller;


import com.mvger.demo.model.Animal;
import com.mvger.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // внести зависимость в билдгрэдл спринг бут стартер веб
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping(path = "/animals") // делаем реквест по пути animals в url
    public ResponseEntity<?> getAnimals() { // возваращает ResponseEntity, параметризованный любым классом
        List<Animal> allAnimals = animalService.getAllAnimals(); // получаем список животных
        return new ResponseEntity<>(allAnimals, HttpStatus.OK); // получаем ответ в браузере списком всех животных
    }

    @GetMapping(path = "/animals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // добавляем к пути id и предоставляем данные в JSON
    public ResponseEntity<?> getAnimalById(@PathVariable Long id) {
        Animal animalById = animalService.getAnimalById(id);
        return new ResponseEntity<>(animalById, HttpStatus.OK);
    }

    @PostMapping(path = "/animals")
    public ResponseEntity<?> createAuthor(@RequestBody Animal animal) {
        animalService.createAnimal(animal);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/animals/{id}")
    public ResponseEntity<?> updateAnimal(@PathVariable Long id,
                                          @RequestParam String name) {
        animalService.updateAnimalNameById(id, name);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/animals/{id}")
    public ResponseEntity<?> deleteAnimalById(@PathVariable Long id) {
        animalService.deleteAnimalById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
