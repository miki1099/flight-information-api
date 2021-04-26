package com.example.flightapi.controller;

import com.example.flightapi.exception.BadTimeFormatException;
import com.example.flightapi.model.dto.CreateFlightDto;
import com.example.flightapi.model.dto.FlightWeightDto;
import com.example.flightapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/flight/add")
    public long addFlightAndGetId(@Valid @RequestBody CreateFlightDto createFlightDto) {
        return flightService.createFlightAndReturnId(createFlightDto);
    }

    @GetMapping(value = "/flight/weight")
    public FlightWeightDto getFlightWeight(@RequestParam int flightNumber, @RequestParam String date,
                                           @RequestParam boolean weightInKg) {
        String weightUnit = weightInKg ? "kg" : "lb";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date flightDate = null;
        try {
            flightDate = format.parse(date);
        } catch (ParseException e) {
            throw new BadTimeFormatException("Wrong time format. Valid is: yyyy-MM-dd HH:mm:ss");
        }
        return flightService.getFlightWeights(flightNumber,
                flightDate, weightUnit);
    }
}
