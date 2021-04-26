package com.example.flightapi.service.implementation;

import com.example.flightapi.model.Baggage;
import com.example.flightapi.model.Cargo;
import com.example.flightapi.model.Flight;
import com.example.flightapi.model.FlightCargo;
import com.example.flightapi.model.dto.AirportInfoDto;
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

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class AirportServiceImplTest {

    @Mock
    private FlightCargoRepository cargoRepository;

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private AirportServiceImpl airportService;

    private final FlightCargo flightCargo = new FlightCargo();
    private final FlightCargo flightCargo1 = new FlightCargo();

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

        Flight flight1 = new Flight();
        flight1.setFlightId(2L);
        flight1.setArrivalAirportIATACode("BBB");
        flight1.setDepartureAirportIATACode("AAA");
        flight1.setFlightNumber(FLIGHT_NUMBER);
        flight1.setDepartureDate(FLIGHT_DATE);

        Cargo cargo10 = new Cargo();
        cargo10.setId(2L);
        cargo10.setPieces(2);
        cargo10.setWeight(87);
        cargo10.setWeightUnit("lb");

        Baggage baggage1 = new Baggage();
        baggage1.setId(3L);
        baggage1.setPieces(934);
        baggage1.setWeight(827);
        baggage1.setWeightUnit("lb");

        Baggage baggage2 = new Baggage();
        baggage2.setId(4L);
        baggage2.setPieces(823);
        baggage2.setWeight(827);
        baggage2.setWeightUnit("kg");

        List<Cargo> cargos1 = List.of(cargo10);
        List<Baggage> baggageList1 = List.of(baggage1, baggage2);

        flightCargo1.setFlight(flight1);
        flightCargo1.setCargo(cargos1);
        flightCargo1.setBaggage(baggageList1);
        flightCargo1.setId(2L);
    }

    @Test
    void getFlightNumbersAndBaggageNumber() {

        when(cargoRepository.findAllByFlight_ArrivalAirportIATACode(anyString()))
                .thenReturn(List.of(flightCargo1));

        when(cargoRepository.findAllByFlight_DepartureAirportIATACode(anyString()))
                .thenReturn(List.of(flightCargo));

        when(flightRepository.countAllByArrivalAirportIATACode(anyString())).thenReturn(1);
        when(flightRepository.countAllByDepartureAirportIATACode(anyString())).thenReturn(1);
        AirportInfoDto actualInfo = airportService.getFlightNumbersAndBaggageNumber("IAT");

        assertEquals(934, actualInfo.getBaggageDepartingPieces());
        assertEquals(1_757, actualInfo.getBaggageArrivingPieces());
        assertEquals(1, actualInfo.getArrivingFlightsNumber());
        assertEquals(1, actualInfo.getDepartingFlightsNumber());
    }
}