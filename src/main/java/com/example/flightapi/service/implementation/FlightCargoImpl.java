package com.example.flightapi.service.implementation;

import com.example.flightapi.exception.FlightNotFoundException;
import com.example.flightapi.model.*;
import com.example.flightapi.model.dto.BaggageCargoEntityDto;
import com.example.flightapi.model.dto.CreateFlightCargoDto;
import com.example.flightapi.repository.BaggageRepository;
import com.example.flightapi.repository.CargoRepository;
import com.example.flightapi.repository.FlightCargoRepository;
import com.example.flightapi.repository.FlightRepository;
import com.example.flightapi.service.FlightCargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FlightCargoImpl implements FlightCargoService {

    private final FlightCargoRepository flightCargoRepository;
    private final FlightRepository flightRepository;
    private final BaggageRepository baggageRepository;
    private final CargoRepository cargoRepository;

    @Override
    @Transactional
    public void createCargo(CreateFlightCargoDto newCargo) {
        FlightCargo flightToSave = mapFlightCargo(newCargo);
        flightCargoRepository.save(flightToSave);
    }

    Flight getOneSafe(Long flightId) {
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
        try {
            flightCargo.setBaggage(
                    baggageRepository.saveAll(mapBaggageCargo(newCargo.getBaggage(), Baggage.class))
            );
            flightCargo.setCargo(
                    cargoRepository.saveAll(mapBaggageCargo(newCargo.getCargo(), Cargo.class))
            );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return flightCargo;
    }

    private <T extends BaggageCargoEntity> List<T> mapBaggageCargo(List<BaggageCargoEntityDto> baggageSet, Class<T> type) throws IllegalAccessException, InstantiationException {
        List<T> baggageToSave = new ArrayList<>();
        for (BaggageCargoEntityDto baggage: baggageSet) {
            T baggageBuffer = type.newInstance();
            baggageBuffer.setPieces(baggage.getPieces());
            baggageBuffer.setWeight(baggage.getWeight());
            baggageBuffer.setWeightUnit(baggage.getWeightUnit());
            baggageToSave.add(baggageBuffer);
        }
        return baggageToSave;
    }
}
