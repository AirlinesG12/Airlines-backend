package com.lti.service;

import java.util.List;

import com.lti.entity.Ticket;


public interface CancelService {

	Ticket findTicketById(long ticketId);
	Ticket cancelTicket(long ticketId,double cancelCharges);
	List<Ticket> viewCancelledTicketsByUserId(long userId);

}
