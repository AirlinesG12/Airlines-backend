package com.lti.service;

import com.lti.entity.Flight;

public interface AdminService {

	long addAFlight(Flight flight);
	Flight removeAFlight(long flightId);
}
