package com.lti.repository;

import com.lti.entity.Flight;

public interface AdminRepository {

	Flight addAFlight(Flight flight);
	Flight removeAFlight(long flightId);
}

