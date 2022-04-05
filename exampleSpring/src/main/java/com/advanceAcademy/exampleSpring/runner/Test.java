package com.advanceAcademy.exampleSpring.runner;

import com.advanceAcademy.exampleSpring.models.Car;
import com.advanceAcademy.exampleSpring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        Car car = new Car(1L,"BMW", "320", "Diesel", "200", 2010);
        Car car2 = new Car(2L, "AUDI", "A8", "Petrol", "300", 2010);
        Car car3 = new Car(3L, "Opel", "Astra", "Diesel", "120", 2010);

        carRepository.save(car);
        carRepository.save(car2);
        carRepository.save(car3);

        carRepository.delete(car);
    }
}
