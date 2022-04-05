package com.advanceAcademy.exampleSpring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "model", length = 50, nullable = false)
    private String model;

    @Column(name = "engine", length = 50, nullable = false)
    private String engine;

    @Column(name = "hp", nullable = false)
    private String horsePower;

    @Column(name = "year", nullable = false)
    private int year;
}
