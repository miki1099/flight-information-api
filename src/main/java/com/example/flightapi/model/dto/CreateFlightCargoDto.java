package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class CreateFlightCargoDto {

    private final long flightId;
    private final Set<BaggageCargoEntityDto> baggage;
    private final Set<BaggageCargoEntityDto> cargo;

}
