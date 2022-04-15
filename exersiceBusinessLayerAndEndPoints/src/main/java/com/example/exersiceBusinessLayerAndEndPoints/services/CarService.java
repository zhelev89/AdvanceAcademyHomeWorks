package com.example.exersiceBusinessLayerAndEndPoints.services;

import com.example.exersiceBusinessLayerAndEndPoints.entities.Car;
import com.example.exersiceBusinessLayerAndEndPoints.exceptions.NotFoundRecordException;
import com.example.exersiceBusinessLayerAndEndPoints.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Set<Car> findAll() {
        return new HashSet<>(carRepository.findAll());
    }

    public Car find(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundRecordException(
                        String.format("Car with id:%s, not found", id)));
    }

    public Car update(Car updatedCar, Long id) {
        Car car = find(id);
        if (updatedCar.getBrand() == null) {
            updatedCar.setBrand(car.getBrand());
        }
        if (updatedCar.getModel() == null) {
            updatedCar.setModel(car.getModel());
        }
        if (updatedCar.getYear() == 0) {
            updatedCar.setYear(car.getYear());
        }

        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());

        return carRepository.save(car);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
