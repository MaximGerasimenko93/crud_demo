package com.mvger.demo.repository;

import com.mvger.demo.model.Animal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// Метод обновляет поля в animals по id
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Modifying // аннотация нужна, чтобы мы могли делать не только SELECT
    @Query("update Animal a set a.name = :name where a.id = :id")
    void updateAnimalById(Long id, String name);
}
