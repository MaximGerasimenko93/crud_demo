package com.mvger.demo.repository;

import com.mvger.demo.model.Animal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Modifying
    @Query("update Animal a set a.name = :name where a.id = :id")
    void updateAnimalById(Long id, String name);
}
