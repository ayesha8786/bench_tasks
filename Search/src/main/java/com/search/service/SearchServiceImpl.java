package com.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.search.entity.FlightDetails;
import com.search.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchRepository searchRepo;

	@Override
	public List<FlightDetails> getAllDetails() {
		List<FlightDetails> FlightDetails = new ArrayList<FlightDetails>();
		searchRepo.findAll().forEach(FlightDetails1 -> FlightDetails.add(FlightDetails1));
		return FlightDetails;
	}


	@Override
	public List<FlightDetails> findByDeparture(String departure, String arrival, String flightDate) {
		return searchRepo.findByDeparture(departure, arrival, flightDate);
	}

}