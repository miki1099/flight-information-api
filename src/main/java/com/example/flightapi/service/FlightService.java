package com.example.flightapi.service;

import com.example.flightapi.model.dto.CreateFlightDto;
import com.example.flightapi.model.dto.FlightWeightDto;

import java.util.Date;

public interface FlightService {

    void createFlight(CreateFlightDto newFlight);

    FlightWeightDto getFlightWeights(int flightNumber, Date date, String weightUnit);
}
