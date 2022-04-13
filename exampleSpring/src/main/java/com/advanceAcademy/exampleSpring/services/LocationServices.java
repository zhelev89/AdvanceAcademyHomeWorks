package com.advanceAcademy.exampleSpring.services;

import com.advanceAcademy.exampleSpring.models.Location;
import com.advanceAcademy.exampleSpring.repositories.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationServices {

    private final LocationRepository locationRepository;

    public Location save(Location location) {
        return locationRepository.save(location);
    }
}
