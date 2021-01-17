package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Admin;
import com.lti.entity.Flight;
import com.lti.entity.User;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Flight addAFlight(Flight flight) {
		return em.merge(flight);
	}
	
	@Transactional
	public Flight removeAFlight(long flightId) {
		Flight flight=em.find(Flight.class, flightId);
		em.remove(flight);
		return flight;
	}
	
	public Admin findAdminById(long adminId) {
		return em.find(Admin.class, adminId);
	}
	
	@Transactional
	public long addAAdmin(Admin admin) {
		Admin adminNew = em.merge(admin);
		return adminNew.getAdminId();
	}
	
	public boolean isValidAdmin(String adminName, String password) {
		String jpql = "select a from Admin a where a.adminName=:aname and a.password=:apass";
		TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
		query.setParameter("aname", adminName);
		query.setParameter("apass", password);
		Admin admin = query.getSingleResult();
		if (admin != null) {
			return true;
		}
		return false;
	}
	
	public List<Flight> viewAllFlights() {
		String jpql = "select a from Flight a";
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		List<Flight> flights = query.getResultList();
		return flights;
	}

}

