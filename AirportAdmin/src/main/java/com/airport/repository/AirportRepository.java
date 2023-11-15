package com.airport.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.airport.entity.FlightDetails;

@Repository
public interface AirportRepository extends MongoRepository<FlightDetails, Integer> {
	public FlightDetails findByFlightNo(int flightNo);
}
