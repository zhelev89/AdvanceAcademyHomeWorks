package com.advanceAcademy.exampleSpring.repositories;

import com.advanceAcademy.exampleSpring.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
