package com.example.course.exception;

public class RunOutOfLessonsException extends RuntimeException {
    public RunOutOfLessonsException(String message) {
        super(message);
    }
}
