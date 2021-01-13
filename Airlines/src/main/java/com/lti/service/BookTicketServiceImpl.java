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
	
	public List<Flight> searchFlight(String source,String Destination) {
		return bookingsRepository.searchFlight(source, Destination);
	}

	@Override
	public long numberOfSeatsAvailable(LocalDate travelDate, long flightId) {
		return bookingsRepository.numberOfSeatsAvailable(travelDate, flightId);
	}

	@Override
	public long checkSeat(LocalDate travelDate, long flightId, long seatNo) {
		return bookingsRepository.checkSeat(travelDate, flightId, seatNo);
	}

	@Override
	public List<Long> seatsNotAvailable(LocalDate travelDate, long flightId) {
		return bookingsRepository.seatsNotAvailable(travelDate, flightId);
	}

}
