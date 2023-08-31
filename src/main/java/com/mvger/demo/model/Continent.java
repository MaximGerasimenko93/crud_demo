package com.mvger.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
