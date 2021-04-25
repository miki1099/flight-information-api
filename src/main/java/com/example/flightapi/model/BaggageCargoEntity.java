package com.example.flightapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "baggage_cargo_entity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaggageCargoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weight;

    @Column(length = 2)
    private String weightUnit;

    private int pieces;
}
