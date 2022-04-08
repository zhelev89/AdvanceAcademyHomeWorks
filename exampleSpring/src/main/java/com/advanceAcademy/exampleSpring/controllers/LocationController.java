package com.advanceAcademy.exampleSpring.controllers;

import com.advanceAcademy.exampleSpring.models.Location;
import com.advanceAcademy.exampleSpring.services.LocationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    private LocationServices locationServices;

    @Autowired
    public LocationController(LocationServices locationServices) {
        this.locationServices = locationServices;
    }

    @PostMapping(value = "/location/save")
    public String save(@RequestBody Location location) {
        locationServices.save(location);
        return "Location successfully save";
    }
}
