package com.utfpr.todo.clean.domain.vo;

import java.time.LocalDateTime;

import com.utfpr.todo.exceptions.ValidationException;

// value object
public class DateTimeRange {

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public DateTimeRange(LocalDateTime startAt, LocalDateTime endAt) {
        this.isInvalidStartAt(startAt);
        this.isInvalidEndAt(startAt, endAt);
        this.startAt = startAt;
        this.endAt = endAt;
    }

    private void isInvalidStartAt(LocalDateTime startAt) {
        LocalDateTime currentDate = LocalDateTime.now();
        if (currentDate.isAfter(startAt)) {
            throw new ValidationException("StartAt must be a future date");
        }
    }

    private void isInvalidEndAt(LocalDateTime startAt, LocalDateTime endAt) {
        if (endAt.isBefore(startAt)) {
            throw new ValidationException("EndAt must be after StartAt");
        }
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }
}
