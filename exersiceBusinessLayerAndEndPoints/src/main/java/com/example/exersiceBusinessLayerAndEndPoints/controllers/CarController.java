package com.example.exersiceBusinessLayerAndEndPoints.controllers;

import com.example.exersiceBusinessLayerAndEndPoints.converters.CarConverter;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car.CarResponse;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car.CarSaveRequest;
import com.example.exersiceBusinessLayerAndEndPoints.entities.Car;
import com.example.exersiceBusinessLayerAndEndPoints.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cars")
public class CarController {

    private CarService carService;
    private CarConverter carConverter;

    @PostMapping
    public ResponseEntity<CarResponse> save(@RequestBody CarSaveRequest carSaveRequest) {
        Car car = carConverter.convert(carSaveRequest);
        Car savedCar = carService.save(car);
        CarResponse carResponse = carConverter.convert(savedCar);
        return ResponseEntity.status(HttpStatus.CREATED).body(carResponse);
    }

    @GetMapping
    public ResponseEntity<Set<CarResponse>> findAll() {
        Set<CarResponse> carResponses = carService.findAll().stream()
                .map(car -> carConverter.convert(car))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(carResponses);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.find(id));
    }

}
