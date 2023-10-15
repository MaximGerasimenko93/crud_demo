package com.mvger.demo.repository;

import com.mvger.demo.model.Animal;
import com.mvger.demo.model.Continent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContinentRepositoryTest {

    @Autowired
    private ContinentRepository continentRepository;

    private final static Long CONTINENT_ID_FOR_TEST = 1L;

    @Test
    void checkUpdatingById() {
        Continent continent = continentRepository.save(Continent.builder()
                .area("Австралия")
                .build());
        continentRepository.updateAreaById(CONTINENT_ID_FOR_TEST, "Австралия");
        Optional<Continent> optionalContinent = continentRepository.findById(CONTINENT_ID_FOR_TEST);
        assertThat(continent).isEqualTo(optionalContinent.get());
    }

    @Test
    void checkInsertingContinent() {
        Continent continent = new Continent();
        continent.setArea("Австралия");
        Continent insertedContinent = continentRepository.save(continent);
        Long insertedId = insertedContinent.getId();
        Optional<Continent> optionalContinent = continentRepository.findById(insertedId);
        assertThat(continent).isEqualTo(optionalContinent.get());
    }

    @Test
    void returningContinentById() {
        Optional<Continent> optionalContinent = continentRepository.findById(CONTINENT_ID_FOR_TEST);
        Continent Continent = optionalContinent.orElseGet(Continent::new);
        assertThat(optionalContinent).isPresent().get().isEqualTo(Continent);
    }


    @Test
    void deleteContinentById() {
        assertThatCode(() -> continentRepository.findById(CONTINENT_ID_FOR_TEST))
                .doesNotThrowAnyException();

        Optional<Continent> optionalContinent = continentRepository.findById(CONTINENT_ID_FOR_TEST);
        Assertions.assertEquals(Optional.empty(), optionalContinent);
    }

    @Test
    void checkFindAll() {
        Iterable<Continent> all = continentRepository.findAll();
        ArrayList<Continent> continents = new ArrayList<>();
        all.forEach(continents::add);
        assertThat(continents.get(0).getArea()).isEqualTo("Австралия");
    }
}
