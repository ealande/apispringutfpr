package com.utfpr.todo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.utfpr.todo.clean.domain.entity.Task;
import com.utfpr.todo.exceptions.ValidationException;

public class TaskTest {

    @Test
    void createTaskWithInvalidDescription() {
        assertThrows(ValidationException.class, () -> {
            Task.create("user1", "Title", "Desc", "low", LocalDateTime.now(), LocalDateTime.now().plusDays(1));
        });
    }

    @Test
    void createTaskWithInvalidPriority() {
        assertThrows(ValidationException.class, () -> {
            Task.create("user1", "Title", "Description with more than 10 characters", "invalidPriority",
                    LocalDateTime.now(), LocalDateTime.now().plusDays(1));
        });
    }

    @Test
    void createTaskWithInvalidStartAt() {
        assertThrows(ValidationException.class, () -> {
            Task.create("user1", "Title", "Description with more than 10 characters", "low",
                    LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        });
    }

    @Test
    void createTaskWithInvalidEndAt() {
        assertThrows(ValidationException.class, () -> {
            Task.create("user1", "Title", "Description with more than 10 characters", "low",
                    LocalDateTime.now(), LocalDateTime.now().minusDays(1));
        });
    }

    @Test
    void completeCompletedTask() {
        Task task = Task.create("user1", "Title", "Description with more than 10 characters", "low",
                LocalDateTime.now(), LocalDateTime.now().plusDays(1));
        task.complete();
        assertThrows(ValidationException.class, task::complete);
    }

    @Test
    void getTitle() {
        Task task = Task.create("user1", "Title", "Description with more than 10 characters", "low",
                LocalDateTime.now(), LocalDateTime.now().plusDays(1));
        assertEquals("Title", task.getTitle());
    }

}
