package com.mvger.demo.repository;

import com.mvger.demo.model.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AnimalRepositoryTest {

    private final static Long ANIMAL_ID_FOR_TEST = 1L;

    @Autowired
    private AnimalRepository animalRepository;


    @Test
    void checkUpdatingById() {
        Animal animal = animalRepository.save(Animal.builder()
                .name("Тюлень-монах")
                .build());
        animalRepository.updateAnimalById(ANIMAL_ID_FOR_TEST, "Тюлень-монах");
        Optional<Animal> optionalAnimal = animalRepository.findById(ANIMAL_ID_FOR_TEST);
        assertThat(animal).isEqualTo(optionalAnimal.get());
    }

    @Test
    void checkInsertingAnimal() {
        Animal animal = new Animal();
        animal.setName("Тюлень-монах");
        Animal insertedAnimal = animalRepository.save(animal);
        Long insertedId = insertedAnimal.getId();
        Optional<Animal> optionalAnimal = animalRepository.findById(insertedId);
        assertThat(animal).isEqualTo(optionalAnimal.get());
    }

    @Test
    void returningAnimalById() {
        Optional<Animal> optionalAnimal = animalRepository.findById(ANIMAL_ID_FOR_TEST);
//        Как-то нужно найти класс Animal и id
//        assertThat(optionalAnimal).isPresent().get().isEqualTo();
    }


    @Test
    void deleteAnimalById() {
        assertThatCode(() -> animalRepository.findById(ANIMAL_ID_FOR_TEST))
                .doesNotThrowAnyException();

        Optional<Animal> optionalAnimal = animalRepository.findById(ANIMAL_ID_FOR_TEST);
        assertEquals("Животное удалено", Optional.empty(), optionalAnimal);
    }

    @Test
    void checkFindAll() {
        Iterable<Animal> all = animalRepository.findAll();
        List<Animal> animals = new ArrayList<>();
        all.forEach(animals::add);
        assertThat(animals.get(0).getName()).isEqualTo("");

        // не могу понять почему ошибка в длине массива
    }
}