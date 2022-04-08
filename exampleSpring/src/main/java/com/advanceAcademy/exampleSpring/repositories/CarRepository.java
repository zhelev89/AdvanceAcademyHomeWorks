package com.advanceAcademy.exampleSpring.repositories;

import com.advanceAcademy.exampleSpring.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
