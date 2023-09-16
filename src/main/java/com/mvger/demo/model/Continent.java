package com.mvger.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity // Создаем сущность
@Data // геттеры, сеттеры, хэшкод, иквалс, тустринг
@NoArgsConstructor // конструктор без аргументов
@AllArgsConstructor // конструктор с аргументами
@Table(name = "continents") // Указываем таблицу continents
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "area")
    private String area;

    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Population> populations;
}
