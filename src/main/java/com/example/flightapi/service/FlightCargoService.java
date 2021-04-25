package com.example.flightapi.service;

import com.example.flightapi.model.dto.CreateFlightCargoDto;

public interface FlightCargoService {

    void createCargo(CreateFlightCargoDto newCargo);
}
