package com.example.flightapi.repository;

import com.example.flightapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    int countAllByArrivalAirportIATACode(String IATACode);

    int countAllByDepartureAirportIATACode(String IATACode);

    Optional<Flight> findFirstByFlightId(Long flightId);
}
