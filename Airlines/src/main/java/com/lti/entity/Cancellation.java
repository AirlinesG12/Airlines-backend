package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cancellation")
public class Cancellation {

	@Id
	@SequenceGenerator(name = "seq_cancellation",initialValue = 70001,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cancellation")
	long cancellationId;
	double refundAmount;
	long ticketId;
	
	/*@OneToOne
	@JoinColumn(name="ticketId")
	Ticket ticket;*/

	public long getCancellationId() {
		return cancellationId;
	}

	public void setCancellationId(long cancellationId) {
		this.cancellationId = cancellationId;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	/*public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}*/

	
	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "Cancellation [cancellationId=" + cancellationId + ", refundAmount=" + refundAmount + "]";
	}
	
	
}
