package com.search.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.search.entity.FlightDetails;
import com.search.entity.FlightDetailsList;
import com.search.service.SearchService;
import com.search.service.SearchServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/travel")
public class SearchController {
	@Autowired
	private SearchService service;
	private FlightDetailsList flightList;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/flights")
	public List<FlightDetails> getAllDetails() {
		return service.getAllDetails();
	}
	
	@GetMapping("/places")
	public List<FlightDetails> getFlightDetailsByStartStation(@RequestParam String departure,
			@RequestParam String arrival, @RequestParam String flightDate) {
		return service.findByDeparture(departure, arrival, flightDate);
	}

}