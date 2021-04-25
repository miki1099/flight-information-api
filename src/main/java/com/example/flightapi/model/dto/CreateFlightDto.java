package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class CreateFlightDto {

    private final Integer flightNumber;
    private final String departureAirportIATACode;
    private final String arrivalAirportIATACode;
    private final Date departureDate;
}
