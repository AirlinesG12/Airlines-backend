package com.lti.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bookings;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.service.BookTicketService;
import com.lti.service.BookingService;

@RestController
@CrossOrigin

public class FindBookingsResource {
	@Autowired
	BookTicketService bookingsService;
	
	@Autowired
	BookingService bookings;


	@GetMapping(value="/findTicketById")
	public Ticket findTicketById(@RequestParam("ticketId") long ticketId) {
	return bookingsService.findTicketById(ticketId);
	}

	@GetMapping(value="/findUserByUserId")
	public User findBookingsByBookingId(@RequestParam("userId") long userId) {
	
	return bookingsService.findUserById(userId);
}
	@GetMapping(value="/findBookingsById")
	public Bookings findBookingsById(@RequestParam("bookingId") long bookingId) {
	return bookings.findBookingsByBookingId(bookingId);
	}

	@GetMapping(value="/findBookingsByUserId")
		public Bookings findBookingsByUserId(@RequestParam("userId") long userId) {
		return bookings.findBookingsByBookingId(userId);
	}
		
	}	
	
