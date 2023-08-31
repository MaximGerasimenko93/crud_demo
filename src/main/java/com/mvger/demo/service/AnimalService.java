package com.mvger.demo.service;

import com.mvger.demo.model.Animal;

import java.util.List;

public interface AnimalService {

    void createAnimal(Animal animal);

    Animal getAnimalById(Long id);

    List<Animal> getAllAnimals();

    void deleteAnimalById(Long id);

    void updateAnimalNameById(Long id, String name);
}
