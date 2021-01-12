package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public long bookATicket(Bookings booking) {
		return em.merge(booking).getBookingId();
	}
	
	public Bookings findBookingsByBookingId(long bookingId) {
		return em.find(Bookings.class, bookingId);
	}
	public Flight findFlightById(long flightId) {
		return em.find(Flight.class, flightId);
	}
	
	public Bookings findBookingsByUserId(long userId){
		return em.find(Bookings.class, userId);
	}
	

}
