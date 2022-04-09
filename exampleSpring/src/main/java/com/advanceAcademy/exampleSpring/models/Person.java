package com.advanceAcademy.exampleSpring.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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
    private Location location;

    @ManyToMany
    @JoinTable(name = "persons_cars",
            joinColumns = @JoinColumn(name = "cars_id"),
            inverseJoinColumns = @JoinColumn(name = "persons_id"))
    private Set<Car> cars;

}
