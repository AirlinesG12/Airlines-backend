package com.lti.repository;

import java.util.List;

import com.lti.entity.Ticket;

public interface CancelRepository {

	Ticket findTicketById(long ticketId);
	Ticket cancelTicket(long ticketId,double cancelCharges);
	List<Ticket> viewCancelledTicketsByUserId(long userId,String cancelled);

}
