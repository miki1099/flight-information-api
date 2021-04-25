package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class BaggageCargoEntityDto {

    @Min(1)
    @Max(999)
    private final int weight;

    @Size(min = 2, max = 2)
    @NotBlank
    private final String weightUnit;

    @Min(1)
    @Max(999)
    private final int pieces;
}
