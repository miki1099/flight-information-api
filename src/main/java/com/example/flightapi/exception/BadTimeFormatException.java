package com.example.flightapi.exception;

public class BadTimeFormatException extends RuntimeException{
    public BadTimeFormatException(String message) {
        super(message);
    }
}
