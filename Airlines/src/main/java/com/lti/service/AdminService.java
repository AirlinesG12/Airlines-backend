package com.lti.service;

import com.lti.entity.Flight;

public interface AdminService {

	Flight addAFlight(Flight flight);
	Flight removeAFlight(long flightId);
}
