package com.example.flightapi.controller;

import com.example.flightapi.model.dto.CreateFlightCargoDto;
import com.example.flightapi.service.FlightCargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FlightCargoController {

    private final FlightCargoService cargoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/cargo/add")
    public void addNewCargo(@Valid @RequestBody CreateFlightCargoDto createFlightCargoDto) {
        cargoService.createCargo(createFlightCargoDto);
    }
}
