package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class CreateFlightCargoDto {

    private final Long flightId;

    private final List<@Valid BaggageCargoEntityDto> baggage;

    private final List<@Valid BaggageCargoEntityDto> cargo;

}
