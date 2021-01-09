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
@Table(name = "tbl_passanger")
public class Passanger {

	@Id
	@SequenceGenerator(name = "seq_passanger",initialValue = 20001,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_passanger")
	long passangerId;
	String passangerName;
	String passangerMobile;
	String passangerEmail;
	String passangerAddress;
	
	@OneToOne(mappedBy = "passanger",cascade = CascadeType.ALL)
	Ticket ticket;
	
	@ManyToOne()
	@JoinColumn(name="bookingId")
	Bookings bookings;

	public long getPassangerId() {
		return passangerId;
	}

	public void setPassangerId(long passangerId) {
		this.passangerId = passangerId;
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

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Bookings getBookings() {
		return bookings;
	}

	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Passanger [passangerId=" + passangerId + ", passangerName=" + passangerName + ", passangerMobile="
				+ passangerMobile + ", passangerEmail=" + passangerEmail + ", passangerAddress=" + passangerAddress
				+ "]";
	}
	
	
	
}
