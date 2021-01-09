package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "tbl_bookings")
public class Bookings {

	@Id
	@SequenceGenerator(name = "seq_bookings",initialValue = 50001,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_bookings")
	long bookingId;
	double totalFare;
	
	@ManyToOne
	@JoinColumn(name="userId")
	User user;
	
	@OneToMany(mappedBy = "bookings",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Passanger>passanger;
	
	@OneToMany(mappedBy = "bookings",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Ticket>ticket;
	
	/*@OneToOne
	@JoinColumn(name = "flightId")
	Flight flight;*/

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Passanger> getPassanger() {
		return passanger;
	}

	public void setPassanger(List<Passanger> passanger) {
		this.passanger = passanger;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

	/*public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}*/

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", totalFare=" + totalFare + "]";
	}
	
	
	
}
