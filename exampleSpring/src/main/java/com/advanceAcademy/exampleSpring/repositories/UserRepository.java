package com.advanceAcademy.exampleSpring.repositories;

import com.advanceAcademy.exampleSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
