package com.airport.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airport.entity.FlightDetails;
import com.airport.repository.AirportRepository;

@Service

public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportRepository airportRepository;

	public List<FlightDetails> getAllDetails() {
		List<FlightDetails> FlightDetails = new ArrayList<FlightDetails>();
		airportRepository.findAll().forEach(FlightDetails1 -> FlightDetails.add(FlightDetails1));
		// To check while testing..
		// System.out.println(FlightDetails);
		return FlightDetails;
	}

	public void addFlightDetails(FlightDetails flightDetails) {
		airportRepository.save(flightDetails);
	}

	public FlightDetails updateFlightDetails(int flightNo, FlightDetails flightDetails) {
		FlightDetails existingDetails = airportRepository.findByFlightNo(flightNo);

		existingDetails.setDeparture(flightDetails.getDeparture());
		existingDetails.setArrival(flightDetails.getArrival());
		existingDetails.setArrivalTime(flightDetails.getArrivalTime());
		existingDetails.setDepartureTime(flightDetails.getDepartureTime());
		existingDetails.setDuration(flightDetails.getDuration());
		existingDetails.setNoOfSeats(flightDetails.getNoOfSeats());
		existingDetails.setEconomyClass(flightDetails.getEconomyClass());
		existingDetails.setPremiumEconomy(flightDetails.getPremiumEconomy());
		existingDetails.setPremiumEconomy(flightDetails.getPremiumEconomy());

		return airportRepository.save(existingDetails);
	}

	@Override
	public ResponseEntity<FlightDetails> deleteFlightDetails(int flightNo) {
		FlightDetails existingDetails = airportRepository.findByFlightNo(flightNo);
		airportRepository.delete(existingDetails);
		return ResponseEntity.ok().build();
	}

	@Override
	public FlightDetails findByFlightNo(int flightNo) {
		return airportRepository.findByFlightNo(flightNo);
	}
}
