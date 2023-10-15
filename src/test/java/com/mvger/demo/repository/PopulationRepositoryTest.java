package com.mvger.demo.repository;


import com.mvger.demo.model.Continent;
import com.mvger.demo.model.Population;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.util.AssertionErrors;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PopulationRepositoryTest {

    @Autowired
    private PopulationRepository populationRepository;

    private final static Long POPULATION_ID_FOR_TEST = 1L;

    @Test
    void checkUpdatingById() {
        Population population = populationRepository.save(Population.builder()
                .number(300)
                .build());
        populationRepository.updateNumberById(POPULATION_ID_FOR_TEST, 300);
        Optional<Population> optionalPopulation = populationRepository.findById(POPULATION_ID_FOR_TEST);
        assertThat(population).isEqualTo(optionalPopulation.get());
    }

    @Test
    void checkInsertingPopulation() {
        Population population = new Population();
        population.setNumber(300);
        Population insertedPopulation = populationRepository.save(population);
        Long insertedId = insertedPopulation.getId();
        Optional<Population> optionalPopulation = populationRepository.findById(insertedId);
        assertThat(population).isEqualTo(optionalPopulation.get());
    }

    @Test
    void returningPopulationById() {
        Optional<Population> optionalPopulation = populationRepository.findById(POPULATION_ID_FOR_TEST);
        Population population = optionalPopulation.orElseGet(Population::new);
        assertThat(optionalPopulation).isPresent().get().isEqualTo(population);
    }


    @Test
    void deletePopulationById() {
        assertThatCode(() -> populationRepository.findById(POPULATION_ID_FOR_TEST))
                .doesNotThrowAnyException();

        Optional<Population> optionalPopulation = populationRepository.findById(POPULATION_ID_FOR_TEST);
        assertEquals("Удаление", Optional.empty(), optionalPopulation);
    }

    @Test
    void checkFindAll() {
        Iterable<Population> all = populationRepository.findAll();
        ArrayList<Population> populations = new ArrayList<>();
        all.forEach(populations::add);
        assertEquals("Соответствие", populations.get(0), populations.get(0).getNumber().equals(300));
    }
}
