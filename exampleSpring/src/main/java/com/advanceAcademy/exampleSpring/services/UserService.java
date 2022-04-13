package com.advanceAcademy.exampleSpring.services;

import com.advanceAcademy.exampleSpring.exceptions.DuplicateRecordException;
import com.advanceAcademy.exampleSpring.exceptions.NotFoundRecordException;
import com.advanceAcademy.exampleSpring.models.User;
import com.advanceAcademy.exampleSpring.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("User with username: \"%s\" already exist.", user.getUsername()));
        }
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundRecordException(String.format("User with id:%s, not found", id)));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundRecordException(
                        String.format("User with username: %s, not found", username)));
    }

    @Transactional
    public User updateUsername(User updated, Long id) {
        User updatedUser = findById(id);
        updatedUser.setUsername(updated.getUsername());
        return updatedUser;
    }
}
