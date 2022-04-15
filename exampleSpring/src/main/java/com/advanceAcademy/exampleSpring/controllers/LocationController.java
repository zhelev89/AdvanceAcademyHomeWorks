package com.advanceAcademy.exampleSpring.controllers;

import com.advanceAcademy.exampleSpring.models.Location;
import com.advanceAcademy.exampleSpring.services.LocationServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LocationController {

    private LocationServices locationServices;

    @PostMapping(value = "/location/save")
    public String save(@RequestBody Location location) {
        locationServices.save(location);
        return "Location successfully save";
    }
}
