package com.mvger.demo.repository;

import com.mvger.demo.model.Animal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// Метод обновляет поля в animals по id
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Modifying // аннтация нужна, чтобы мы могли делать не только SELECT
    @Query("")
    void updateAnimalById(Long id, String name);

//    TODO: подумать над запросом и подумать над таблицами. Правильно ли сделал
}
