package com.lti.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.Flight;
import com.lti.service.AdminService;

@Controller
public class AdminResource {

	@Autowired
	AdminService adminService;
	
	public long addAFlight(Flight flight) {
		return adminService.addAFlight(flight);
	}
	
	public Flight removeAFlight(long flightId) {
		return adminService.removeAFlight(flightId);
	}
}

