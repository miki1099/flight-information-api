package com.example.flightapi.repository;

import com.example.flightapi.model.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository extends JpaRepository<Baggage, Long> {
}
