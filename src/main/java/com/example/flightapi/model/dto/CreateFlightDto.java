package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Getter
public class CreateFlightDto {

    @Min(1000)
    @Max(9999)
    private final Integer flightNumber;

    @NotBlank
    private final String departureAirportIATACode;

    @NotBlank
    private final String arrivalAirportIATACode;

    @NotNull
    private final Date departureDate;
}
