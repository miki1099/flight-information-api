package com.example.flightapi.controller;

import com.example.flightapi.model.dto.AirportInfoDto;
import com.example.flightapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping(value = "/airport/getFlightAndBaggageNumbers/{IATACode}")
    public AirportInfoDto getFlightAndBaggageNumbers(@PathVariable String IATACode) {
        return airportService.getFlightNumbersAndBaggageNumber(IATACode);
    }
}
