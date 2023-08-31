package com.mvger.demo.service;


import com.mvger.demo.model.Population;

import java.util.List;

public interface PopulationService {

    void createPopulation(Population population);

    Population getPopulationById(Long id);

    List<Population> getAllPopulations();

    void deletePopulationById(Long id);

    void updatePopulationById(Long id, Integer number);
}
