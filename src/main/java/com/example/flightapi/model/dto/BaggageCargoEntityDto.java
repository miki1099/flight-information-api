package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
public class BaggageCargoEntityDto {

    @Min(1)
    @Max(999)
    private final int weight;

    @Pattern(regexp = "(?:^|(?<= ))(lb|kg)(?:(?= )|$)", message = "units can be only in kg or lb.")
    private final String weightUnit;

    @Min(1)
    @Max(999)
    private final int pieces;
}
