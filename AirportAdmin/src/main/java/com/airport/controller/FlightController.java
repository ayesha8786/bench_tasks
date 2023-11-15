
package com.airport.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.airport.entity.FlightDetails;
import com.airport.service.AirportService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class FlightController {
	@Autowired
	private AirportService airportService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/flights")
	public List<Object> getAllFlights() {
		Object[] flights = restTemplate.getForObject("http://Search/travel/flights", Object[].class);
		return Arrays.asList(flights);
	}

	@GetMapping("/{flightNo}")

	public FlightDetails getDetailsByFlightNo(@PathVariable Integer flightNo) {
		return airportService.findByFlightNo(flightNo);
	}

	@PostMapping("/add")
	public String addFlightDetails(@Valid @RequestBody FlightDetails flightDetails) {
		airportService.addFlightDetails(flightDetails);
		return ("Added flight details with flightNumber - " + flightDetails.getFlightNo() + " successfully..!!");
	}

	@PutMapping("/updateflight/{flightNo}")
	public FlightDetails updateFlightDetails(@PathVariable Integer flightNo, @RequestBody FlightDetails flightDetails) {
		return airportService.updateFlightDetails(flightNo, flightDetails);
	}

	@DeleteMapping("/delete/{flightNo}")
	public ResponseEntity<FlightDetails> deleteFlightDetails(@PathVariable Integer flightNo) {
		return airportService.deleteFlightDetails(flightNo);
	}

	/*
	 * update the no of seats based on the no of passengers that booked ticket
	 * 
	 * @GetMapping("/updateSeats/{flightNo}/{noOfPassengers}") public void
	 * updateSeats(@PathVariable int flightNo, @PathVariable int noOfPassengers) {
	 * FlightDetails currentflight = airportService.findByFlightNo(flightNo); int
	 * initialSeats = currentflight.getNoOfSeats(); int finalSeats = initialSeats -
	 * noOfPassengers; currentflight.setNoOfSeats(finalSeats);
	 * airportService.updateFlightDetails(flightNo, currentflight); }
	 */
}
