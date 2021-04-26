package com.example.flightapi.exception;

public class CargoForFlightAlreadyExistsException extends RuntimeException{
    public CargoForFlightAlreadyExistsException(String message) {
        super(message);
    }
}
