package com.example.course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = {RunOutOfLessonsException.class})
    public ResponseEntity<Object> handleRunOutOfLessonsException(RunOutOfLessonsException e){
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {SubscriptionAlreadySubscribedException.class})
    public ResponseEntity<Object> handleSubscriptionAlreadySubscribedException(SubscriptionAlreadySubscribedException e){
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
