package com.mvger.demo.repository;

import com.mvger.demo.model.Continent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContinentRepository extends CrudRepository<Continent, Long> {

    @Modifying
    @Query("update Continent a set a.area = :area where a.id = :id")
    void updateAreaById(Long id, String area);
}
