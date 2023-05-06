package com.example.course.exception;

public class SubscriptionAlreadySubscribedException extends RuntimeException{

    public SubscriptionAlreadySubscribedException(String message) {
        super(message);
    }
}
