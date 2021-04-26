package com.example.flightapi.service.implementation;

import com.example.flightapi.exception.FlightNotFoundException;
import com.example.flightapi.model.BaggageCargoEntity;
import com.example.flightapi.model.Flight;
import com.example.flightapi.model.FlightCargo;
import com.example.flightapi.model.dto.CreateFlightDto;
import com.example.flightapi.model.dto.FlightWeightDto;
import com.example.flightapi.repository.FlightCargoRepository;
import com.example.flightapi.repository.FlightRepository;
import com.example.flightapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightCargoRepository cargoRepository;

    @Override
    @Transactional
    public long createFlightAndReturnId(CreateFlightDto newFlight) {
        Flight flightToSave = mapFlight(newFlight);
        flightRepository.save(flightToSave);
        return flightToSave.getFlightId();
    }

    @Override
    public FlightWeightDto getFlightWeights(int flightNumber, Date date, String weightUnit) {
        Optional<FlightCargo> flight = cargoRepository
                .findFirstByFlight_FlightIdAndFlight_DepartureDate(flightNumber, date);
        if (flight.isPresent()) {
            FlightCargo flightCargo = flight.get();
            double cargoWeight = countWeight(flightCargo.getCargo(), weightUnit);
            double baggageWeight = countWeight(flightCargo.getBaggage(), weightUnit);
            return new FlightWeightDto(cargoWeight, baggageWeight, cargoWeight + baggageWeight);
        } else {
            throw new FlightNotFoundException("Flight with number: " + flightNumber + " and date: " +
                    date.toString() + " does not exist in database.");
        }
    }

    private Flight mapFlight(CreateFlightDto newFlight) {
        Flight flight = new Flight();
        flight.setFlightNumber(newFlight.getFlightNumber());
        flight.setDepartureDate(newFlight.getDepartureDate());
        flight.setDepartureAirportIATACode(newFlight.getDepartureAirportIATACode());
        flight.setArrivalAirportIATACode(newFlight.getArrivalAirportIATACode());
        return flight;
    }

    private <T extends BaggageCargoEntity> double countWeight(List<T> baggage, String weightUnit) {
        double weightCounter = 0;
        for (BaggageCargoEntity baggageCargo : baggage) {
            if (baggageCargo.getWeightUnit().equals(weightUnit)) {
                weightCounter += baggageCargo.getWeight();
            } else {
                if (weightUnit.equals("kg")) {
                    weightCounter += baggageCargo.getWeight() * 0.45359237;
                } else {
                    weightCounter += baggageCargo.getWeight() * 2.20462262185;
                }
            }
        }
        return weightCounter;
    }
}
