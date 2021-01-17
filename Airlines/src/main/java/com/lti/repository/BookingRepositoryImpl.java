package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	
	public List<Bookings> getBookingsByUserId(long userId) {
		try {
			String jpql="select b from Bookings b where b.user.userId=:uid";
			TypedQuery<Bookings>query=em.createQuery(jpql,Bookings.class);
			query.setParameter("uid",userId);
			List<Bookings>bookings=query.getResultList();
			return bookings;
		}catch (Exception e) {
			return null;
		}
		
	}
	
	

}
