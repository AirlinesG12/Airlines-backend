package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Cancellation;
import com.lti.entity.Ticket;


@Repository
public class CancelRepositoryImpl implements CancelRepository {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Ticket cancelTicket(long ticketId,double cancelCharges) {
		Ticket ticket=em.find(Ticket.class, ticketId);
		ticket.setTicketStatus("Cancelled");
		Cancellation cancellation = new Cancellation();
		cancellation.setTicketId(ticketId);
		cancellation.setRefundAmount(ticket.getFare()-cancelCharges);
		em.merge(cancellation);
		em.remove(ticket);
		return ticket;
	}

	@Override
	public List<Ticket> viewCancelledTicketsByUserId(long userId, String cancelled) {
		String jpql="select t from Ticket t where t.userId=:uid and t.ticketStatus=:canc";
		TypedQuery<Ticket>query=em.createQuery(jpql,Ticket.class);
		query.setParameter("uid", userId);
		query.setParameter("canc", cancelled);
		List<Ticket>tickets=query.getResultList();
		return tickets;
	}
	
	public Ticket findTicketById(long ticketId) {
		return em.find(Ticket.class, ticketId);
	}

}
