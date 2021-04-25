package com.example.flightapi.controller;

import com.example.flightapi.model.dto.CreateFlightDto;
import com.example.flightapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/flight/add")
    private void addFlight(@Valid @RequestBody CreateFlightDto createFlightDto) {
        flightService.createFlight(createFlightDto);
    }
}
