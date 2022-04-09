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

import java.util.Arrays;

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

        Location location = new Location();
        location.setCountry("Bulgaria");
        location.setTown("Varna");
        location.setStreet("P.Slaveikov");
        location.setPostCode("9000");
        location.setPhoneNumber("0899123123");
        Location savedLocation = locationRepository.save(location);

        Car car = new Car();
        car.setBrand("BMW");
        car.setModel("i3");
        car.setEngine("Electric");
        car.setHorsePower("500");
        car.setYear(2021);

        Car car2 = new Car();
        car2.setBrand("Audi");
        car2.setModel("A8");
        car2.setYear(2020);
        car2.setEngine("Diesel");
        car2.setHorsePower("600");
        carRepository.saveAll(Arrays.asList(car, car2));

        Person person = new Person();
        person.setFullName("Zhivko Zhelev");
        person.setAge(32);
        person.setUcn("1010101010");
        person.setLocation(savedLocation);
        personRepository.save(person);

        //ок сега как да свържа колите към персоната при положение, че са manyToMany?
    }
}