package com.mvger.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Создаем сущность
@Data // геттеры, сеттеры, хэшкод, иквалс, тустринг
@NoArgsConstructor // конструктор без аргументов
@AllArgsConstructor // конструктор с аргументами
@Table(name = "animals") // Указываем таблицу animals
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Задаем первичый ключ
    private long id;

    @Column(name = "name")
    private String name;

}