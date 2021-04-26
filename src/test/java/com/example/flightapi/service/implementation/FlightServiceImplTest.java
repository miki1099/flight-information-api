package com.example.flightapi.service.implementation;

import com.example.flightapi.model.Baggage;
import com.example.flightapi.model.Cargo;
import com.example.flightapi.model.Flight;
import com.example.flightapi.model.FlightCargo;
import com.example.flightapi.model.dto.FlightWeightDto;
import com.example.flightapi.repository.FlightCargoRepository;
import com.example.flightapi.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    FlightCargoRepository cargoRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    private final FlightCargo flightCargo = new FlightCargo();

    private final int FLIGHT_NUMBER = 8374;
    private final Date FLIGHT_DATE = new Date();

    @BeforeEach
    void setup() {
        Flight flight = new Flight();
        flight.setFlightId(1L);
        flight.setArrivalAirportIATACode("AAA");
        flight.setDepartureAirportIATACode("BBB");
        flight.setFlightNumber(FLIGHT_NUMBER);
        flight.setDepartureDate(FLIGHT_DATE);

        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setPieces(93);
        cargo.setWeight(834);
        cargo.setWeightUnit("kg");

        Cargo cargo1 = new Cargo();
        cargo1.setId(2L);
        cargo1.setPieces(2);
        cargo1.setWeight(87);
        cargo1.setWeightUnit("lb");

        Cargo cargo2 = new Cargo();
        cargo2.setId(3L);
        cargo2.setPieces(999);
        cargo2.setWeight(999);
        cargo2.setWeightUnit("kg");

        Cargo cargo3 = new Cargo();
        cargo3.setId(4L);
        cargo3.setPieces(1);
        cargo3.setWeight(1);
        cargo3.setWeightUnit("lb");

        Baggage baggage = new Baggage();
        baggage.setId(1L);
        baggage.setPieces(934);
        baggage.setWeight(827);
        baggage.setWeightUnit("lb");

        List<Cargo> cargos = List.of(cargo, cargo1, cargo2, cargo3);
        List<Baggage> baggageList = List.of(baggage);

        flightCargo.setFlight(flight);
        flightCargo.setCargo(cargos);
        flightCargo.setBaggage(baggageList);
        flightCargo.setId(1L);
    }

    @Test
    void getFlightWeights() {

        when(cargoRepository.findFirstByFlight_FlightNumberAndFlight_DepartureDate(anyInt(), any()))
                .thenReturn(Optional.of(flightCargo));

        FlightWeightDto flightWeightInKg = flightService.getFlightWeights(FLIGHT_NUMBER, FLIGHT_DATE, "kg");
        assertEquals(375.121, flightWeightInKg.getBaggageWeight(), 0.001);
        assertEquals(1_872.9161, flightWeightInKg.getCargoWeight(), 0.001);
        assertEquals(2_248.0371, flightWeightInKg.getTotalWeight(), 0.001);

        FlightWeightDto flightWeightInLb = flightService.getFlightWeights(FLIGHT_NUMBER, FLIGHT_DATE, "lb");
        assertEquals(827, flightWeightInLb.getBaggageWeight(), 0.001);
        assertEquals(4_129.08, flightWeightInLb.getCargoWeight(), 0.01);
        assertEquals(4_956.08, flightWeightInLb.getTotalWeight(), 0.01);
    }
}