package com.example.flightapi.service.implementation;

import com.example.flightapi.exception.FlightNotFoundException;
import com.example.flightapi.model.BaggageCargoEntity;
import com.example.flightapi.model.Flight;
import com.example.flightapi.model.FlightCargo;
import com.example.flightapi.model.dto.BaggageCargoEntityDto;
import com.example.flightapi.model.dto.CreateFlightCargoDto;
import com.example.flightapi.repository.FlightCargoRepository;
import com.example.flightapi.repository.FlightRepository;
import com.example.flightapi.service.FlightCargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FlightCargoImpl implements FlightCargoService {

    private final FlightCargoRepository cargoRepository;
    private final FlightRepository flightRepository;

    @Override
    @Transactional
    public void createCargo(CreateFlightCargoDto newCargo) {
        FlightCargo flightToSave = mapFlightCargo(newCargo);
        cargoRepository.save(flightToSave);
    }

    Flight getOneSafe(int flightId) {
        Optional<Flight> flight = flightRepository.findFirstByFlightId(flightId);
        if(flight.isPresent()) {
            return flight.get();
        } else {
            throw new FlightNotFoundException("Flight with this number is not present in database");
        }
    }

    private FlightCargo mapFlightCargo(CreateFlightCargoDto newCargo) {
        FlightCargo flightCargo = new FlightCargo();
        flightCargo.setFlight(getOneSafe(newCargo.getFlightId()));
        flightCargo.setBaggage(mapBaggageCargo(newCargo.getBaggage()));
        flightCargo.setCargo(mapBaggageCargo(newCargo.getCargo()));
        return flightCargo;
    }

    private Set<BaggageCargoEntity> mapBaggageCargo(Set<BaggageCargoEntityDto> baggageSet) {
        Set<BaggageCargoEntity> baggageToSave = new HashSet<>();
        for (BaggageCargoEntityDto baggage: baggageSet) {
            BaggageCargoEntity baggageBuffer = new BaggageCargoEntity();
            baggageBuffer.setPieces(baggage.getPieces());
            baggageBuffer.setWeight(baggage.getWeight());
            baggageBuffer.setWeightUnit(baggage.getWeightUnit());
            baggageToSave.add(baggageBuffer);
        }
        return baggageToSave;
    }
}
