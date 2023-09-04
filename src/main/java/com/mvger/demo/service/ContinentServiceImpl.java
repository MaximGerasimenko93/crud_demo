package com.mvger.demo.service;

import com.mvger.demo.model.Continent;
import com.mvger.demo.repository.ContinentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContinentServiceImpl implements ContinentService {

    private final ContinentRepository continentRepository;

    @Override
    @Transactional(readOnly = false)
    public void addContinent(Continent continent) {
        log.info("Добавляем континент в таблицу: ", continent);
        Continent continent1 = continentRepository.save(continent);
    }

    @Override
    @Transactional(readOnly = true)
    public Continent getContinentById(Long id) {
        log.info("Вытаскиваем континент по id: ", id);
        return continentRepository.findById(id)
                .orElseGet(() -> {
                    log.info("Животное не найдено по id");
                    return new Continent();
                });
    }

    @Override
    @Transactional(readOnly = true)
    public List<Continent> getAllContinents() {
        log.info("Список животных по id: + \n");
        Iterable<Continent> continents = continentRepository.findAll();
        List<Continent> list = new ArrayList<>();
        continents.forEach(list::add);
        return list;
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteContinentById(Long id) {
        log.info("Удаление континента по id: ", id);
        continentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateContinentById(Long id, String area) {
        log.info("Обновление животного по имени");
       continentRepository.updateAreaById(id, area);
    }
}

