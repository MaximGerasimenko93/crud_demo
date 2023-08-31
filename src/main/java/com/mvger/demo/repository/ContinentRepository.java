package com.mvger.demo.repository;

import com.mvger.demo.model.Continent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContinentRepository extends CrudRepository<Continent, Long> {

    @Modifying // аннтация нужна, чтобы мы могли делать не только SELECT
    @Query("")
    void updateAreaById(Long id, String area);
}
