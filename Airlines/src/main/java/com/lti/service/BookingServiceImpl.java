package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.repository.BookingRepositoryImpl;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepositoryImpl bookingsRepository;
	public long bookATicket(Bookings booking) {
		
		return bookingsRepository.bookATicket(booking);
	}
	public Bookings findBookingsByBookingId(long bookingId) {
		return bookingsRepository.findBookingsByBookingId(bookingId);
	}
	public Flight findFlightById(long flightId) {
		return bookingsRepository.findFlightById(flightId);
	}
	public Bookings findBookingsByUserId(long userId) {
		 return bookingsRepository.findBookingsByUserId(userId);
	 }
	
}
