package com.advanceAcademy.exampleSpring.runner;

import com.advanceAcademy.exampleSpring.models.Person;
import com.advanceAcademy.exampleSpring.repositories.CarRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Person person = new Person();
        person.setFullName("Zhivko Zhelev");
        person.setAge(32);
        person.setUcn("1010101010");
    }
}
