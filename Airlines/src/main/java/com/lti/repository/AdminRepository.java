package com.lti.repository;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Flight;

public interface AdminRepository {

	Flight addAFlight(Flight flight);
	Flight removeAFlight(long flightId);
	boolean isValidAdmin(String adminName, String password);
	long addAAdmin(Admin admin);
	Admin findAdminById(long adminId);
	List<Flight> viewAllFlights();
}

