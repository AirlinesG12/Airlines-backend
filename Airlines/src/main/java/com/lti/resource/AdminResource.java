package com.lti.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Flight;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminResource {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/addFlight", method = RequestMethod.POST)
	public Flight addAFlight(@RequestBody Flight flight) {
		return adminService.addAFlight(flight);
	
	}
	
	@RequestMapping(value="/removeAFlight/{fid}")
	public Flight removeAFlight(@PathVariable("fid") long flightId) {
		Flight result=adminService.removeAFlight(flightId);
		return result;
	}
}

