package com.advanceAcademy.exampleSpring.services;

import com.advanceAcademy.exampleSpring.models.Car;
import com.advanceAcademy.exampleSpring.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CarServices {

    private final CarRepository carRepository;

    @Autowired
    public CarServices(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElse(new Car());
    }
}
