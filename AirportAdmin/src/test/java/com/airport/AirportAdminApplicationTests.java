package com.airport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.airport.service.AirportServiceImpl;
import com.airport.entity.FlightDetails;

@SpringBootTest
class AirportAdminApplicationTests {

	@Autowired
	AirportServiceImpl asi;
	
	@Test
	void contextLoads() {
		int flightNo=1514;
		FlightDetails fd = new FlightDetails();
		fd.setArrival("Hyd");
		fd.setArrivalTime("19:00");
		fd.setDeparture("Bangalore");
		fd.setDepartureTime("18:00");
		fd.setDuration("1hr");
		fd.setEconomyClass(100000);
		fd.setFlightDate("11/11/2023");
		fd.setNoOfSeats(100);
		fd.setPremiumEconomy(200000);
		fd.setBusinessClass(150000);
		asi.updateFlightDetails(flightNo, fd);
	}

}
