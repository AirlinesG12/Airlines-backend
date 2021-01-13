package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	public List<Flight> searchFlight(String source,String destination) {
		String jpql="select f from Flight f where f.source=:sour and f.destination=:dest ";
		TypedQuery<Flight>query=em.createQuery(jpql,Flight.class);
		query.setParameter("sour", source);
		query.setParameter("dest", destination);
		List<Flight> flights=query.getResultList();
		return flights;
	}
	@Override
	public long numberOfSeatsAvailable(LocalDate travelDate, long flightId) {
		long count;
		String jpql="select count(t) from Ticket t where t.travelDate=:tdate and t.flight.flightId=:fid";
		Query query=em.createQuery(jpql);
		query.setParameter("tdate", travelDate);
		query.setParameter("fid", flightId);
		count=(long)query.getSingleResult();
		return 50-count;
	}
	@Override
	public long checkSeat(LocalDate travelDate, long flightId,long seatNo) {
		long count;
		String jpql="select count(t) from Ticket t where t.travelDate=:tdate and t.flight.flightId=:fid and t.seatNumber=:sno";
		Query query=em.createQuery(jpql);
		query.setParameter("tdate", travelDate);
		query.setParameter("fid", flightId);
		query.setParameter("sno", seatNo);
		count=(long)query.getSingleResult();
		return count;
	}
	@Override
	public List<Long> seatsNotAvailable(LocalDate travelDate, long flightId) {
		String jpql="select t.seatNumber from Ticket t where t.travelDate=:tdate and t.flight.flightId=:fid";
		Query query=em.createQuery(jpql);
		query.setParameter("tdate", travelDate);
		query.setParameter("fid", flightId);
		return query.getResultList();
	}
}
