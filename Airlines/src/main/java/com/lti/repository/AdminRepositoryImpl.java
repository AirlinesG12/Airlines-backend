package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Flight;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public long addAFlight(Flight flight) {
		return em.merge(flight).getFlightId();
	}
	
	@Transactional
	public Flight removeAFlight(long flightId) {
		Flight flight=em.find(Flight.class, flightId);
		em.remove(flight);
		return flight;
	}

}

