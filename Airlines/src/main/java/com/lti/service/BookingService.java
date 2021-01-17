package com.lti.service;

import java.util.List;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;

public interface BookingService {
	
	long bookATicket(Bookings booking);
	Bookings findBookingsByBookingId(long bookingId);
	Flight findFlightById(long flightId);
	 Bookings findBookingsByUserId(long userId);
	 List<Bookings> getBookingsByUserId(long userId);
}
