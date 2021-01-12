package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.repository.BookTicketRepository;

@Service
public class BookTicketServiceImpl implements BookTicketService {

	@Autowired
	BookTicketRepository bookingsRepository;

	public long bookATicket(Bookings booking) {
		
		return bookingsRepository.bookATicket(booking);
	}
	
	public User findUserById(long userId) {
		return bookingsRepository.findUserById(userId);
	}
	public Flight findFlightById(long flightId) {
		return bookingsRepository.findFlightById(flightId);
	}
	
	public Ticket findTicketById(long ticketId) {
		return bookingsRepository.findTicketById(ticketId);
	}
	
	public List<Flight> searchFlight(LocalDate departureDate,String source,String Destination) {
		return bookingsRepository.searchFlight(departureDate, source, Destination);
	}
public 	Bookings findBookingsByBookingId(long bookingId) {
		return bookingsRepository.findBookingsByBookingId(bookingId);
	}
public Bookings findTicketsByBookingId(long bookingId) {
	return bookingsRepository.findTicketsByBookingId(bookingId);
}
}
