package com.example.flightapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @Min(1000)
    @Max(9999)
    private Integer flightNumber;

    @Column(length = 3)
    @NotBlank
    private String departureAirportIATACode;

    @Column(length = 3)
    @NotBlank
    private String arrivalAirportIATACode;

    @NotNull
    private Date departureDate;
}
