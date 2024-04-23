// UserController.java
package com.utfpr.todo.users.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.todo.users.application.UserService;
import com.utfpr.todo.users.domain.model.User;
import com.utfpr.todo.users.presentation.dto.UserCreationRequestDTO;
import com.utfpr.todo.users.presentation.dto.UserOutputDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserOutputDTO> create(@RequestBody UserCreationRequestDTO requestDTO) {
        User user = userService.createUser(requestDTO.getUsername(), requestDTO.getName(), requestDTO.getEmail(),
                requestDTO.getPassword());

        UserOutputDTO outputDTO = UserOutputDTO.fromEntity(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(outputDTO);
    }
}
