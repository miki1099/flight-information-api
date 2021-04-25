package com.example.flightapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flight_cargo_cargo")
public class Cargo extends BaggageCargoEntity{
}
