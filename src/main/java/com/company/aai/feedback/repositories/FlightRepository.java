package com.company.aai.feedback.repositories;

import com.company.aai.feedback.models.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {
}
