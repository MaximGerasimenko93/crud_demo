package com.mvger.demo.repository;

import com.mvger.demo.model.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AnimalRepositoryTest {

    private final static Long ANIMAL_ID_FOR_TEST = 1L;

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    void checkUpdatingById() {
        animalRepository.updateAnimalById(ANIMAL_ID_FOR_TEST, "Тюлень-монах");
        Optional<Animal> optionalAnimal = animalRepository.findById(ANIMAL_ID_FOR_TEST);
        assertTrue(optionalAnimal.isPresent());
    }

    @Test
    void checkInsertingAnimal() {
        Animal animal = new Animal();
        animal.setName("Тюлень-монах");
        Animal insertedAnimal = animalRepository.save(animal);
        Long insertedId = insertedAnimal.getId();
        Optional<Animal> optionalAnimal = animalRepository.findById(insertedId);
        assertThat(animal).isEqualTo(optionalAnimal);
    }

    @Test
    void returningAnimalById() {
        Optional<Animal> optionalAnimal = animalRepository.findById(ANIMAL_ID_FOR_TEST);
        Animal animal = optionalAnimal.orElseGet(Animal::new);
        assertThat(optionalAnimal).isPresent().get().isEqualTo(animal);
    }


    @Test
    void deleteAnimalById() {

//        Assert.notNull(id, ID_MUST_NOT_BE_NULL);
//		delete(findById(id).orElseThrow(() -> new EmptyResultDataAccessException
        assertThatCode(() -> animalRepository.findById(ANIMAL_ID_FOR_TEST))
                .doesNotThrowAnyException();

        Optional<Animal> optionalAnimal = animalRepository.findById(ANIMAL_ID_FOR_TEST);
        assertEquals("Животное удалено", Optional.empty(), optionalAnimal);
    }

    // в ячейке массива 0 лежит соответствующее животное. Можно лучше.

    @Test
    void checkFindAll() {
        Iterable<Animal> all = animalRepository.findAll();
        ArrayList<Animal> animals = new ArrayList<>();
        all.forEach(animals::add);
        assertEquals("Соответствие", animals.get(0), animals.get(0).getName().equals("Тюлень-монах"));
    }
}