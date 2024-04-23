package com.utfpr.todo.clean.application.usecase.create_task;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskOutput {

    private String id;

    private String userId;

    private String title;

    private String description;

    private String priority;

    private boolean completed;

    private LocalDateTime startAt;

    private LocalDateTime endAt;
    
}
