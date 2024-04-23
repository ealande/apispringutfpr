package com.utfpr.todo.users.presentation.dto;

import lombok.Data;

@Data
public class UserCreationRequestDTO {
    private String username;
    private String name;
    private String email;
    private String password;
}
