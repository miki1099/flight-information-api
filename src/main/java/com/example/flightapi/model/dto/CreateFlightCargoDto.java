package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class CreateFlightCargoDto {

    private final Long flightId;

    private final List<BaggageCargoEntityDto> baggage;

    private final List<BaggageCargoEntityDto> cargo;

}
