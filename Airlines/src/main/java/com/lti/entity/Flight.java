package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_flight")
public class Flight {

	@Id
	@SequenceGenerator(name = "seq_flight",initialValue = 40001,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_flight")
	long flightId;
	String source;
	String destination;
	long noOfSeats;
	LocalDate departureDate;
	
	/*@OneToOne(mappedBy = "flight")
	Bookings bookings;*/
	
	
	/*@ManyToOne
	@JoinColumn(name = "adminId")
	Admin admin;*/
	
	@OneToMany(mappedBy = "flight")
	List<Ticket> tickets;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
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

	public long getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(long noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	/*public Bookings getBookings() {
		return bookings;
	}

	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}*/

	/*public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}*/

	
	
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", noOfSeats="
				+ noOfSeats + ", departureDate=" + departureDate + "]";
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	
	
	
	
}
