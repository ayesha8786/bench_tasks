package com.airport.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.airport.entity.FlightDetails;

public interface AirportService {

	public List<FlightDetails> getAllDetails();

	public FlightDetails findByFlightNo(int flightNo);

	public void addFlightDetails(FlightDetails flightDetails);

	public FlightDetails updateFlightDetails(int flightNo, FlightDetails flightDetails);

	public ResponseEntity<FlightDetails> deleteFlightDetails(int flightNo);

}
