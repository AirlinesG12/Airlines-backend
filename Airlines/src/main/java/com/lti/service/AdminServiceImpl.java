package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Flight;
import com.lti.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	public long addAFlight(Flight flight) {
		
		return adminRepository.addAFlight(flight);
	}
	
	public Flight removeAFlight(long flightId) {
		return adminRepository.removeAFlight(flightId);
	}

}
