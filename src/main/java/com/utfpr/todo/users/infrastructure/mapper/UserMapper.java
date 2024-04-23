package com.utfpr.todo.users.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.utfpr.todo.users.UserModel;
import com.utfpr.todo.users.presentation.dto.UserOutputDTO;

@Component
public class UserMapper {
    
    public UserOutputDTO toOutputDTO(UserModel user) {
        return UserOutputDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .name(user.getName())
            .email(user.getEmail())
            .build();
    }

}
