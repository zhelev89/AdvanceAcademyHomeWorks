package com.advanceAcademy.exampleSpring.runner;

import com.advanceAcademy.exampleSpring.models.Car;
import com.advanceAcademy.exampleSpring.models.Location;
import com.advanceAcademy.exampleSpring.models.Person;
import com.advanceAcademy.exampleSpring.models.User;
import com.advanceAcademy.exampleSpring.services.CarServices;
import com.advanceAcademy.exampleSpring.services.LocationServices;
import com.advanceAcademy.exampleSpring.services.PersonServices;
import com.advanceAcademy.exampleSpring.services.UserService;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class TesterRunner implements CommandLineRunner {

    private CarServices carServices;
    private PersonServices personServices;
    private LocationServices locationServices;
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        Location location = new Location();
        location.setCountry("Bulgaria");
        location.setTown("Varna");
        location.setStreet("P.Slaveikov");
        location.setPostCode("9000");
        Location savedLocation = locationServices.save(location);

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
        carServices.save(car);
        carServices.save(car2);

        Person person = new Person();
        person.setFullName("Zhivko Zhelev");
        person.setAge(32);
        person.setUcn("1010101010");
        person.setLocation(savedLocation);
        personServices.save(person);

        User user = new User();
        user.setUsername("zhelev89");
        user.setPassword("12345");
        userService.save(user);

        /*User updated = new User();
        updated.setUsername("Gosho");
        userService.updateUsername(updated, 1L);

         */
        //ок сега как да свържа колите към персоната при положение, че са manyToMany?
        // в postman като пусна гет заявка да покажа Persona id-1 ми дава
        // "status": 500,
        // "error": "Internal Server Error",

    }
}