package com.example.flightapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@Getter
public class CreateFlightDto {

    @Min(1000)
    @Max(9999)
    private final Integer flightNumber;

    @Size(min = 3, max = 3)
    @NotBlank
    private final String departureAirportIATACode;

    @Size(min = 3, max = 3)
    @NotBlank
    private final String arrivalAirportIATACode;

    @NotNull
    private final Date departureDate;
}
