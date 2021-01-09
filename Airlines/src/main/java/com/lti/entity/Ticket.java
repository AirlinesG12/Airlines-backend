package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ticket3")
public class Ticket {

	@Id
	@SequenceGenerator(name = "seq_ticket",initialValue = 30001,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_ticket")
	long ticketId;
	String source;
	String destination;
	double fare;
	long seatNumber;
	String ticketStatus;
	
	@OneToOne
	@JoinColumn(name = "passangerId")
	Passanger passanger;
	
	@ManyToOne()
	@JoinColumn(name="bookingId")
	Bookings bookings;
	
	/*@OneToOne(mappedBy = "ticket",cascade = CascadeType.ALL)
	Cancellation cancellation;*/
	
	@ManyToOne
	@JoinColumn(name = "flightId")
	Flight flight;

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
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

	public long getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(long seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Passanger getPassanger() {
		return passanger;
	}

	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}

	public Bookings getBookings() {
		return bookings;
	}

	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}

	/*public Cancellation getCancellation() {
		return cancellation;
	}

	public void setCancellation(Cancellation cancellation) {
		this.cancellation = cancellation;
	}*/

	
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", source=" + source + ", destination=" + destination + ", fare=" + fare
				+ ", seatNumber=" + seatNumber + "]";
	}
	
	
}
