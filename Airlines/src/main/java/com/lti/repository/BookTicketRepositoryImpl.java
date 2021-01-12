package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.entity.User;

@Repository
public class BookTicketRepositoryImpl implements BookTicketRepository {

	
	@PersistenceContext
	EntityManager em;

	
	public User findUserById(long userId) {
		return em.find(User.class, userId);
	}
	public Flight findFlightById(long flightId) {
		return em.find(Flight.class, flightId);
	}
	
	public Ticket findTicketById(long ticketId) {
		return em.find(Ticket.class, ticketId);
	}

	@Transactional
	public long bookATicket(Bookings booking) {
		return em.merge(booking).getBookingId();
	}
	
	public List<Flight> searchFlight(LocalDate departureDate,String source,String destination) {
		String jpql="select f from Flight f where f.source=:sour and f.destination=:dest and f.departureDate=:date";
		TypedQuery<Flight>query=em.createQuery(jpql,Flight.class);
		query.setParameter("sour", source);
		query.setParameter("dest", destination);
		query.setParameter("date", departureDate);
		List<Flight> flights=query.getResultList();
		return flights;
	}
	
	public Bookings findBookingsByBookingId(long bookingId) {
		return em.find(Bookings.class,bookingId);
	}

	public Bookings findTicketsByBookingId(long bookingId) {
		return em.find(Bookings.class,bookingId);
	}

}
