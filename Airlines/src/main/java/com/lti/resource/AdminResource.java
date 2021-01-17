package com.lti.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
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
	
	@RequestMapping(value="/viewAllFlights",method=RequestMethod.GET)
	public List<Flight> viewAllFlights() {
		return adminService.viewAllFlights();
	}
	
	@GetMapping(value = "/findAdminById/{aid}") 
	public Admin findAdminById(@PathVariable("aid") long adminId) {
		return adminService.findAdminById(adminId);
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public Admin addAAdmin(@RequestBody Admin admin) {
		long adminId=adminService.addAAdmin(admin);
		Admin admin2= adminService.findAdminById(adminId);
		return admin2;
	}
	
	@RequestMapping(value = "/validAdmin/{adminName}/{password}" )
	public String validAdmin(@PathVariable("adminName") String adminName,@PathVariable("password") String password) {
		if(adminService.isValidAdmin(adminName,password))
		{
			return "Valid Admin";
		}
		else return "Invalid Admin";
	}
	
	@GetMapping(value="/login/{aname}/{apass}")
	public boolean login(@PathVariable("aname") String adminName,@PathVariable("apass") String password) {
		if(adminService.isValidAdmin(adminName, password)) {
			return true;
		}else {
			return false;
		}
	}
}

