package com.lti.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Flight;
import com.lti.entity.Ticket;
import com.lti.service.CancelService;

@RestController
@CrossOrigin
public class CancelResource {

	@Autowired
	CancelService cancelService;
	
	
	@RequestMapping(value="/cancelTicket/{tId}")
	public String cancelTicket(@PathVariable("tId") long ticketId) {
		//long ticketId=7034;
		double cancelCharge;
		Ticket ticket=cancelService.findTicketById(ticketId);
		String status=ticket.getTicketStatus();
		String cancelled="Cancelled";
		//System.out.println(status);
		if(status.equals(cancelled)) {
			return "already cancelled";
		}
		else {
		//System.out.println(ticket.getFlight().getDepartureTime());
		LocalTime dTime=ticket.getFlight().getDepartureTime();
		LocalTime cTime=LocalTime.now();
		int dHour=dTime.getHour();
		int dMin=dTime.getMinute();
		int cHour=cTime.getHour();
		int cMin=cTime.getMinute();
		//System.out.println(dHour + " " + dMin +" " + cHour + " "+ cMin);
		int hourDiff=(dHour-cHour);
		int minDiff=(dMin-cMin);
		int totalTimeDiff=(hourDiff * 60) + minDiff;
		//System.out.println(totalTimeDiff);
		if(ticket.getFlight().getDepartureDate()==LocalDate.now() && totalTimeDiff<180 ) {
			cancelCharge=ticket.getFare()*0.5;
		}
		else
		{
			cancelCharge=ticket.getFare()*0.2;
		}
		return"Ticket Id " + cancelService.cancelTicket(ticketId,cancelCharge).getTicketId() + " has been successfully cancelled" + "Cancellation Charges :"+ cancelCharge;
		}
	}
	
	@RequestMapping("/viewCancelledTickets/{uid}")
	public List<Ticket> viewCancelledTicketsByUserId(@PathVariable("uid") long userId) {
		//long userId=10026;
		List<Ticket>tickets=cancelService.viewCancelledTicketsByUserId(userId);
		return tickets;
	}
	
	
}
