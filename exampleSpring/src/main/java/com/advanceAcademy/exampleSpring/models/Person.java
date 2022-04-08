package com.advanceAcademy.exampleSpring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @NotNull
    @Column(name = "age", nullable = false)
    private int age;

    @NotNull
    @Column(name = "ucn", length = 10, nullable = false)
    private String ucn;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Location location;
}
