package com.search.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.search.entity.FlightDetails;

public interface SearchService {

	public List<FlightDetails> getAllDetails();


	public List<FlightDetails> findByDeparture(String departure, String arrival, String flightDate);

}
