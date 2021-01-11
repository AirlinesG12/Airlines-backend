package com.lti.resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Passanger;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.service.BookingService;

@RestController
@CrossOrigin
public class BookingResource {

	
	@Autowired
	BookingService bookings;
	
	@RequestMapping(value="/bookATicket", method=RequestMethod.POST)
	public Bookings bookATicket(@RequestBody Bookings booking){
	long bookingId=bookings.bookATicket(booking);
	Bookings book=bookings.findBookingsByBookingId(bookingId);
		return book;
	}
	@GetMapping(value="/findBookingsById")
	public Bookings findBookingsById(@RequestParam("bookingId") long bookingId) {
	return bookings.findBookingsByBookingId(bookingId);
	}
	@GetMapping(value="/findFlightsById")
public Flight findFlightsById(@RequestParam("flightId") long flightId) {
	return	bookings.findFlightById(flightId); 
	}
	@GetMapping(value="/findBookingsByUserId")
	public Bookings findBookingsByUserId(@RequestParam("userId") long userId) {
	return bookings.findBookingsByBookingId(userId);
	}
}
