package com.mvger.demo.service;

import com.mvger.demo.model.Continent;

import java.util.List;

public interface ContinentService {

    void addContinent(Continent continent);

    Continent getContinentById(Long id);

    List<Continent> getAllContinents();

    void deleteContinentById(Long id);

    void updateContinentById(Long id, String area);
}
