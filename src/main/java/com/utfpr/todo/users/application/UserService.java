package com.utfpr.todo.users.application;

import com.utfpr.todo.users.domain.model.User;
import com.utfpr.todo.users.infrastructure.repository.UserRepository;
import com.utfpr.todo.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String name, String email, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new ValidationException("Username already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return userRepository.save(user);
    }
}
