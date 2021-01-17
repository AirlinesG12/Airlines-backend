package com.lti.repository;

import java.util.List;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;

public interface BookingRepository {
	long bookATicket(Bookings booking);
	Bookings findBookingsByBookingId(long bookingId);
	Flight findFlightById(long flightId);
    Bookings findBookingsByUserId(long userId);
    List<Bookings> getBookingsByUserId(long userId);
}
