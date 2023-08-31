package com.mvger.demo.repository;

import com.mvger.demo.model.Population;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PopulationRepository extends CrudRepository<Population, Long> {

    @Modifying // аннтация нужна, чтобы мы могли делать не только SELECT
    @Query("")
    void updateNumberById(Long id, Integer number);
}
