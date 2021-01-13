package com.lti.service;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;

public interface BookingService {
	
	long bookATicket(Bookings booking);
	Bookings findBookingsByBookingId(long bookingId);
	Flight findFlightById(long flightId);
	 Bookings findBookingsByUserId(long userId);
}
