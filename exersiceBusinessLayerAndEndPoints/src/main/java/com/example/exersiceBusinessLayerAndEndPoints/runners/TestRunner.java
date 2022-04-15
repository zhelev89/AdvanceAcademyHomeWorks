package com.example.exersiceBusinessLayerAndEndPoints.runners;

import com.example.exersiceBusinessLayerAndEndPoints.entities.Car;
import com.example.exersiceBusinessLayerAndEndPoints.entities.Person;
import com.example.exersiceBusinessLayerAndEndPoints.services.CarService;
import com.example.exersiceBusinessLayerAndEndPoints.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    @Autowired
    private CarService carService;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setFullName("Zhivko Zhelev");
        person.setAge(32);
        person.setUcn("1010101010");
        personService.save(person);

        Car car = new Car();
        car.setBrand("BMW");
        car.setModel("i3");
        car.setYear(2021);
        carService.save(car);

        Person updatedPerson = new Person(null, null, 0, null, car);
        personService.update(updatedPerson, person.getId());

        Car carUpdated = new Car(null, null, "m3", 0);
        carService.update(carUpdated, car.getId());
    }
}
