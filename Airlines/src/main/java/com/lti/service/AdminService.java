package com.lti.service;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Flight;

public interface AdminService {

	Flight addAFlight(Flight flight);
	Flight removeAFlight(long flightId);
	List<Flight> viewAllFlights();
	boolean isValidAdmin(String adminName, String password);
	long addAAdmin(Admin admin);
	Admin findAdminById(long adminId);
}
