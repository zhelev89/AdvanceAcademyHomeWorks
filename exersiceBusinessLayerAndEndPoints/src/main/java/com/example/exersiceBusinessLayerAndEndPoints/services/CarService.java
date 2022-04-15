package com.example.exersiceBusinessLayerAndEndPoints.services;

import com.example.exersiceBusinessLayerAndEndPoints.entities.Car;
import com.example.exersiceBusinessLayerAndEndPoints.exceptions.NotFoundRecordException;
import com.example.exersiceBusinessLayerAndEndPoints.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car find(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundRecordException(
                        String.format("Car with id:%s, not found", id)));
    }

    public Car find(String brand) {
        return carRepository.findByBrand(brand)
                .orElseThrow(() -> new NotFoundRecordException(
                        String.format("Car with brand: %s, not found", brand)));
    }

    public Car find(int year) {
        return carRepository.findByYear(year)
                .orElseThrow(() -> new NotFoundRecordException(
                        String.format("Car with year: %s, not found", year)));
    }
}
