package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class BaggageCargoEntityDto {

    @Min(1)
    @Max(999)
    private final int weight;

    @NotBlank
    private final String weightUnit;

    @Min(1)
    @Max(999)
    private final int pieces;
}
