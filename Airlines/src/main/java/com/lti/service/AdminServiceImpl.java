package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.entity.Flight;
import com.lti.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	public Flight addAFlight(Flight flight) {
		
		return adminRepository.addAFlight(flight);
	}
	
	public Flight removeAFlight(long flightId) {
		return adminRepository.removeAFlight(flightId);
	}
	
	public List<Flight> viewAllFlights() {
		return adminRepository.viewAllFlights();
	}
	
	public Admin findAdminById(long adminId) {
		return adminRepository.findAdminById(adminId);
	}
	
	public long addAAdmin(Admin admin) {

		return adminRepository.addAAdmin(admin);
	}
	
	public boolean isValidAdmin(String adminName, String password) {
		return adminRepository.isValidAdmin(adminName, password);
	}

}
