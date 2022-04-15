package com.advanceAcademy.exampleSpring.repositories;

import com.advanceAcademy.exampleSpring.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUcn(String ucn);
}
