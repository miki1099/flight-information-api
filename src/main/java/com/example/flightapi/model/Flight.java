package com.example.flightapi.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @Min(1000)
    @Max(9999)
    private Integer flightNumber;

    @Column(length = 3)
    private String departureAirportIATACode;

    @Column(length = 3)
    private String arrivalAirportIATACode;

    private Date departureDate;
}
