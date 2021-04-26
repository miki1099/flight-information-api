package com.example.flightapi.service.implementation;

import com.example.flightapi.model.Baggage;
import com.example.flightapi.model.FlightCargo;
import com.example.flightapi.model.dto.AirportInfoDto;
import com.example.flightapi.repository.FlightCargoRepository;
import com.example.flightapi.repository.FlightRepository;
import com.example.flightapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final FlightCargoRepository flightCargoRepository;
    private final FlightRepository flightRepository;

    @Override
    public AirportInfoDto getFlightNumbersAndBaggageNumber(String IATACode) {
        List<FlightCargo> arrivalList = flightCargoRepository.findAllByFlight_ArrivalAirportIATACode(IATACode);
        List<FlightCargo> departureList = flightCargoRepository.findAllByFlight_DepartureAirportIATACode(IATACode);
        int arrivalBaggagePieces = countBaggagePieces(arrivalList);
        int departureBaggagePieces = countBaggagePieces(departureList);
        return new AirportInfoDto(flightRepository.countAllByDepartureAirportIATACode(IATACode),
                flightRepository.countAllByArrivalAirportIATACode(IATACode),
                arrivalBaggagePieces, departureBaggagePieces);
    }

    private int countBaggagePieces(List<FlightCargo> list) {
        int counter = 0;
        for (FlightCargo flightCargo : list) {
            for (Baggage baggage: flightCargo.getBaggage()) {
                counter += baggage.getPieces();
            }
        }
        return counter;
    }
}
