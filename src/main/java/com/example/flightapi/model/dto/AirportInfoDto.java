package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AirportInfoDto {

    private final int departingFlightsNumber;
    private final int arrivingFlightsNumber;
    private final int baggageArrivingPieces;
    private final int baggageDepartingPieces;
}
