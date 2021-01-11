package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.entity.User;

public interface BookTicketService {

	User findUserById(long userId);
	Ticket findTicketById(long ticketId);
	Flight findFlightById(long flightId);
	long bookATicket(Bookings booking);
	List<Flight> searchFlight(LocalDate departureDate,String source,String Destination);
}
