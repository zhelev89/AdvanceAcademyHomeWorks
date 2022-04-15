package com.example.exersiceBusinessLayerAndEndPoints.repositories;

import com.example.exersiceBusinessLayerAndEndPoints.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByBrand(String brand);
    Optional<Car> findByYear(int year);
}
