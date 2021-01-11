package com.lti.dto;

public class BookDto {

	long seatNumber;
	String source;
	String destination;
	double fare;
	String ticketStatus;
	long flightId;
	long passangerId;
	long bookingId;
	long userId;
	
	String passangerName;
	String passangerMobile;
	String passangerEmail;
	String passangerAddress;
	public long getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(long seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public long getPassangerId() {
		return passangerId;
	}
	public void setPassangerId(long passangerId) {
		this.passangerId = passangerId;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	public String getPassangerMobile() {
		return passangerMobile;
	}
	public void setPassangerMobile(String passangerMobile) {
		this.passangerMobile = passangerMobile;
	}
	public String getPassangerEmail() {
		return passangerEmail;
	}
	public void setPassangerEmail(String passangerEmail) {
		this.passangerEmail = passangerEmail;
	}
	public String getPassangerAddress() {
		return passangerAddress;
	}
	public void setPassangerAddress(String passangerAddress) {
		this.passangerAddress = passangerAddress;
	}
	
	
}
