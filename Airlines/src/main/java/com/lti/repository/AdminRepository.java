package com.lti.repository;

import com.lti.entity.Flight;

public interface AdminRepository {

	long addAFlight(Flight flight);
	Flight removeAFlight(long flightId);
}

