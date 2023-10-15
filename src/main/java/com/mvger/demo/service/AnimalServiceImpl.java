package com.mvger.demo.service;

import com.mvger.demo.model.Animal;
import com.mvger.demo.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    @Transactional(readOnly = false)
    public void createAnimal(Animal animal) {
        log.info("Добавляем животное в таблицу: ", animal); // с помощью log добавляем запись в журнал
        Animal animal1 = animalRepository.save(animal);
    }

    @Override
    @Transactional(readOnly = true)
    public Animal getAnimalById(Long id) {
        log.info("Вытаскиваем животное по id: ", id);
        return animalRepository.findById(id)
                .orElseGet(() -> {
                    log.info("Животное не найдено по id");
                    return new Animal();
                });
    }

    @Override
    @Transactional(readOnly = true)
    public List<Animal> getAllAnimals() {
        log.info("Список животных по id: + \n");
        Iterable<Animal> authors = animalRepository.findAll();
        List<Animal> list = new ArrayList<>();
        authors.forEach(list::add);
        return list;
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteAnimalById(Long id) {
        log.info("Удаление животного по id: ", id);
        animalRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateAnimalNameById(Long id, String name) {
        log.info("Обновление животного по имени");
        animalRepository.updateAnimalById(id, name);
    }
}
