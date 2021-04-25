package com.example.flightapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "cargo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Flight flight;

    @OneToMany
    @JoinColumn(name = "flight_cargo_id")
    private List<Baggage> baggage;

    @OneToMany
    @JoinColumn(name = "flight_cargo_id")
    private List<Cargo> cargo;
}
