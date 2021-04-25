package com.example.flightapi.service;

import com.example.flightapi.model.dto.AirportInfoDto;

public interface AirportService {

    AirportInfoDto getFlightNumbersAndBaggageNumber(String IATACode);
}
