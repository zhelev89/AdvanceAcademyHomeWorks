package com.advanceAcademy.exampleSpring.controllers;

import com.advanceAcademy.exampleSpring.models.User;
import com.advanceAcademy.exampleSpring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping(value = "/user/save")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "You successfully saved";
    }

    @GetMapping(value = "/user/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
