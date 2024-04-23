package com.utfpr.todo.users.presentation.dto;

import com.utfpr.todo.users.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOutputDTO {
    private String id;
    private String username;
    private String name;
    private String email;

    public static UserOutputDTO fromEntity(User user) {
        return UserOutputDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
