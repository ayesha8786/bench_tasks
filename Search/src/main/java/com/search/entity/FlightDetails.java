package com.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlightDetails")
public class FlightDetails {
	@Id
	private int flightNo;

	private String departure;

	private String arrival;

	private String arrivalTime;

	private String departureTime;
	private String duration;
	private int noOfSeats;

	private int economyClass;
	private int premiumEconomy;
	private int businessClass;
	private String flightDate;

	public FlightDetails() {
		super();
	}

	public FlightDetails(int flightNo, String departure, String arrival, String arrivalTime, String departureTime,
			String duration, int noOfSeats, int economyClass, int premiumEconomy, int businessClass,
			String flightDate) {
		super();
		this.flightNo = flightNo;
		this.departure = departure;
		this.arrival = arrival;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.duration = duration;
		this.noOfSeats = noOfSeats;
		this.economyClass = economyClass;
		this.premiumEconomy = premiumEconomy;
		this.businessClass = businessClass;
		this.flightDate = flightDate;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getEconomyClass() {
		return economyClass;
	}

	public void setEconomyClass(int economyClass) {
		this.economyClass = economyClass;
	}

	public int getPremiumEconomy() {
		return premiumEconomy;
	}

	public void setPremiumEconomy(int premiumEconomy) {
		this.premiumEconomy = premiumEconomy;
	}

	public int getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(int businessClass) {
		this.businessClass = businessClass;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

}