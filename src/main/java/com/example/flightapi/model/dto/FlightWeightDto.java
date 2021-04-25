package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FlightWeightDto {

    private final int cargoWeight;
    private final int baggageWeight;
    private final int totalWeight;
}
