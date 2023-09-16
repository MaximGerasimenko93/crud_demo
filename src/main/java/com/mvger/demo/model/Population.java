package com.mvger.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Создаем сущность
@Data // геттеры, сеттеры, хэшкод, иквалс, тустринг
@NoArgsConstructor // конструктор без аргументов
@AllArgsConstructor // конструктор с аргументами
@Table(name = "populations") // Указываем таблицу populations
public class Population {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @OneToMany(mappedBy = "population", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Animal> animals;
}
