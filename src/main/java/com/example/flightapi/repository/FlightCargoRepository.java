package com.example.flightapi.repository;

import com.example.flightapi.model.Flight;
import com.example.flightapi.model.FlightCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

public interface FlightCargoRepository extends JpaRepository<FlightCargo, Long> {

    Optional<FlightCargo> findFirstByFlight_FlightIdAndFlight_DepartureDate(long flightId, Date departureDate);

    Set<FlightCargo> findAllByFlight_ArrivalAirportIATACode(String IATACode);

    Set<FlightCargo> findAllByFlight_DepartureAirportIATACode(String IATACode);
}
