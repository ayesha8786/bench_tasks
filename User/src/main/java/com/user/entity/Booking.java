package com.user.entity;

import java.math.BigInteger;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Booking")
public class Booking {
	@Transient
	public static final String SEQUENCE_NAME = "booking_sequence";
	private int bookingId;
	private int flightNo;
	private String name;
	private int age;
	private String gender;
	private String departure;
	private String arrival;
	private String cardName;
	private String cardNumber;
	private int expMonth;
	private int expYear;
	private int cvv;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int bookingId, int flightNo, String name, int age, String gender, String departure, String arrival,
			String cardName, String cardNumber, int expMonth, int expYear, int cvv) {
		super();
		this.bookingId = bookingId;
		this.flightNo = flightNo;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.departure = departure;
		this.arrival = arrival;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", flightNo=" + flightNo + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", departure=" + departure + ", arrival=" + arrival + ", cardName=" + cardName
				+ ", cardNumber=" + cardNumber + ", expMonth=" + expMonth + ", expYear=" + expYear + ", cvv=" + cvv
				+ "]";
	}

}