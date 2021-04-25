package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FlightWeightDto {

    private final double cargoWeight;
    private final double baggageWeight;
    private final double totalWeight;
}
