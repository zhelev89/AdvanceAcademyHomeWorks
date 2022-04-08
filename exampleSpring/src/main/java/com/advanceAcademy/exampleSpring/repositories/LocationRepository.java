package com.advanceAcademy.exampleSpring.repositories;

import com.advanceAcademy.exampleSpring.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
