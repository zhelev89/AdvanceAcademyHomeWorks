package com.example.exersiceBusinessLayerAndEndPoints.repositories;

import com.example.exersiceBusinessLayerAndEndPoints.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByFullName(String fullName);
}
