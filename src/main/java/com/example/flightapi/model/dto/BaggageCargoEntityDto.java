package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaggageCargoEntityDto {

    private final int weight;
    private final String weightUnit;
    private final int pieces;
}
