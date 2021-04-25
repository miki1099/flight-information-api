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
@Table(name = "flight")
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private Integer flightNumber;

    @Column(length = 3)
    private String departureAirportIATACode;

    @Column(length = 3)
    private String arrivalAirportIATACode;

    private Date departureDate;
}
