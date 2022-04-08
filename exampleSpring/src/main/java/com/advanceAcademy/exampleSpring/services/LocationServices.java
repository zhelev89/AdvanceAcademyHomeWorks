package com.advanceAcademy.exampleSpring.services;

import com.advanceAcademy.exampleSpring.models.Location;
import com.advanceAcademy.exampleSpring.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServices {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServices(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public Location findById(Long id) {
        return locationRepository.findById(id).orElse(new Location());
    }
}
