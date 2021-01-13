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
import com.lti.repository.BookingRepository;

@Service
public class BookTicketServiceImpl implements BookTicketService {

	@Autowired
	BookingRepository bookingsRepository;
	
	@Autowired
	BookTicketRepository bookRepository;
	

	public long bookATicket(Bookings booking) {
		
		return bookingsRepository.bookATicket(booking);
	}
	
	public User findUserById(long userId) {
		return bookRepository.findUserById(userId);
	}
	public Flight findFlightById(long flightId) {
		return bookingsRepository.findFlightById(flightId);
	}
	
		
	public List<Flight> searchFlight(String source,String Destination) {
		return bookRepository.searchFlight(source, Destination);
	}

	@Override
	public long numberOfSeatsAvailable(LocalDate travelDate, long flightId) {
		return bookRepository.numberOfSeatsAvailable(travelDate, flightId);
	}

	@Override
	public long checkSeat(LocalDate travelDate, long flightId, long seatNo) {
		return bookRepository.checkSeat(travelDate, flightId, seatNo);
	}

	@Override
	public List<Long> seatsNotAvailable(LocalDate travelDate, long flightId) {
		return bookRepository.seatsNotAvailable(travelDate, flightId);
	}
public 	Bookings findBookingsByBookingId(long bookingId) {
		return bookingsRepository.findBookingsByBookingId(bookingId);
	}
public Bookings findTicketsByBookingId(long bookingId) {
	return bookRepository.findTicketById(bookingId);
}

@Override
public List<Flight> searchFlight(LocalDate departureDate, String source, String Destination) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Ticket findTicketById(long ticketId) {
	// TODO Auto-generated method stub
	return null;
}
}
