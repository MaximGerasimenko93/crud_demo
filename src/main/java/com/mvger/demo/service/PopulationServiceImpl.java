package com.mvger.demo.service;

import com.mvger.demo.model.Animal;
import com.mvger.demo.model.Population;
import com.mvger.demo.repository.PopulationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PopulationServiceImpl implements PopulationService {

    private final PopulationRepository populationRepository;

    @Override
    public void createPopulation(Population population) {
        log.info("Добавляем популяцию в таблицу: ", population);
        Population population1 = populationRepository.save(population);
    }

    @Override
    public Population getPopulationById(Long id) {
        log.info("Ищем популяцию по id: ", id);
        return populationRepository.findById(id)
                .orElseGet(() -> {
                    log.info("Популяция не найдена по id");
                    return new Population();
                });
    }

    @Override
    public List<Population> getAllPopulations() {
        log.info("Список популяций по id: + \n");
        Iterable<Population> populations = populationRepository.findAll();
        List<Population> list = new ArrayList<>();
        populations.forEach(list::add);
        return list;
    }

    @Override
    public void deletePopulationById(Long id) {
        log.info("Удаление популяции по id: ", id);
        populationRepository.deleteById(id);
    }

    @Override
    public void updatePopulationById(Long id, Integer number) {
        log.info("Обновление животного по имени");
        populationRepository.updateNumberById(id, number);
    }
}
