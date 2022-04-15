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
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @NotNull
    @Column(name = "town", length = 100, nullable = false)
    private String town;

    @NotNull
    @Column(name = "street", length = 100, nullable = false)
    private String street;

    @NotNull
    @Column(name = "post_code", length = 20, nullable = false)
    private String postCode;

}
