package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@AllArgsConstructor
@Getter
public class CreateFlightCargoDto {

    @Min(1000)
    @Max(9999)
    private final long flightId;

    private final Set<BaggageCargoEntityDto> baggage;

    private final Set<BaggageCargoEntityDto> cargo;

}
