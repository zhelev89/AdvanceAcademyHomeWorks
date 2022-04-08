package com.advanceAcademy.exampleSpring.controllers;

import com.advanceAcademy.exampleSpring.models.Car;
import com.advanceAcademy.exampleSpring.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private CarServices carServices;

    @Autowired
    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @PostMapping(value = "/car/save")
    private String save(@RequestBody Car car) {
        carServices.save(car);
        return "Car successfully save";
    }

    @GetMapping(value = "/car/find/{id}")
    private Car findById(@PathVariable Long id) {
        return carServices.findById(id);
    }
}
