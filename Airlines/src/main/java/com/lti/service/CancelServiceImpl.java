package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Ticket;
import com.lti.repository.CancelRepository;

@Service
public class CancelServiceImpl implements CancelService {

	@Autowired
	CancelRepository cancelRepository;
	
	@Override
	public Ticket cancelTicket(long ticketId,double cancelCharges) {
		return cancelRepository.cancelTicket(ticketId, cancelCharges);
	}

	@Override
	public 	List<Ticket> viewCancelledTicketsByUserId(long userId){
		return cancelRepository.viewCancelledTicketsByUserId(userId, "Cancelled");
	}

	public Ticket findTicketById(long ticketId) {
		return cancelRepository.findTicketById(ticketId);
	}

}
