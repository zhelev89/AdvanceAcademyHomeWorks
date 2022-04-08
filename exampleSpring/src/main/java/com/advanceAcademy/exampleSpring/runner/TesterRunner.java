package com.advanceAcademy.exampleSpring.runner;

import com.advanceAcademy.exampleSpring.models.Car;
import com.advanceAcademy.exampleSpring.models.Location;
import com.advanceAcademy.exampleSpring.models.Person;
import com.advanceAcademy.exampleSpring.repositories.CarRepository;
import com.advanceAcademy.exampleSpring.repositories.LocationRepository;
import com.advanceAcademy.exampleSpring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TesterRunner implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person = new Person();
        person.setFullName("Zhivko Zhelev");
        person.setAge(32);
        person.setUcn("1010101010");

        Car car = new Car();
        car.setBrand("BMW");
        car.setModel("i3");
        car.setEngine("Electric");
        car.setHorsePower("500");
        car.setYear(2021);

        Location location = new Location();
        location.setCountry("Bulgaria");
        location.setTown("Varna");
        location.setStreet("P.Slaveikov");
        location.setPostCode("9000");
        location.setPhoneNumber("0899123123");

        personRepository.save(person);
        carRepository.save(car);
        locationRepository.save(location);
    }
}
