package com.lti.resource;

import java.util.List;

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
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class FindBookingsResource {
	@Autowired
	BookTicketService bookingsService;
	
	@Autowired
	BookingService bookings;
	
	@Autowired
	UserService userservice;
	
	
	


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
		public List<Bookings> findBookingsByUserId(@RequestParam("userId") long userId) {
		User user = userservice.findUserById(userId);
        List<Bookings>bookings=user.getBookings();
        for(Bookings b : bookings) {
			System.out.println(b.getBookingId() + " " + b.getTotalFare());
		}
        return user.getBookings();  
	
	
	
	}
		@GetMapping(value="/findTicketsByBookingId")
		public List<Ticket> findTicketsByBookingId(@RequestParam("bookingId")long bookingId){
		Bookings book=bookingsService.findBookingsByBookingId(bookingId);
		List<Ticket>tickets=book.getTicket();
		for(Ticket t : tickets) {
			System.out.println(t.getSource()+""+t.getDestination()+""+t.getSeatNumber());
		}
		
		return book.getTicket();
		}
		
	}	
	
