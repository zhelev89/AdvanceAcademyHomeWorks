package com.advanceAcademy.exampleSpring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @NotNull
    @Column(name = "model", length = 50, nullable = false)
    private String model;

    @NotNull
    @Column(name = "engine", length = 50, nullable = false)
    private String engine;

    @NotNull
    @Column(name = "hp", nullable = false)
    private String horsePower;

    @NotNull
    @Column(name = "year", nullable = false)
    private int year;
    
}
