package com.advanceAcademy.exampleSpring.services;

import com.advanceAcademy.exampleSpring.exceptions.NotFoundRecordException;
import com.advanceAcademy.exampleSpring.models.Car;
import com.advanceAcademy.exampleSpring.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServices {

    private final CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundRecordException(String.format("Car with id:%s, not found", id)));
    }
}
