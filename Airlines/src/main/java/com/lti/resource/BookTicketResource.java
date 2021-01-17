package com.lti.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookDto;
import com.lti.entity.Bookings;
import com.lti.entity.Flight;
import com.lti.entity.Passanger;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.service.BookTicketService;

@RestController
@CrossOrigin
public class BookTicketResource {

	@Autowired
	BookTicketService bookingsService;
	
	@RequestMapping(value="bookATicket/{uid}",method = RequestMethod.POST)
	public long bookATicket(@RequestBody List<BookDto> dtoList,@PathVariable("uid") long userId){
		double totalFare=0.0;
		Bookings booking= new Bookings();
		List<Passanger>passangerList= new ArrayList<Passanger>();
		List<Ticket>ticketList = new ArrayList<Ticket>();
		long id;
		for(BookDto dto : dtoList) {
			long seatNumber=dto.getSeatNumber();
			long flightId=dto.getFlightId();
			LocalDate travelDate=dto.getTravelDate();
			
				
			
			id=dto.getUserId();
			//User user=bookingsService.findUserById(dto.getUserId());
			Flight flight;
			flight = bookingsService.findFlightById(dto.getFlightId());
			
			Passanger passanger= new Passanger();
			Ticket ticket = new Ticket();
			ticket.setSeatNumber(dto.getSeatNumber());
			ticket.setSource(dto.getSource());
			ticket.setDestination(dto.getDestination());
			ticket.setFare(dto.getFare());
			ticket.setFlight(flight);
			ticket.setPassanger(passanger);
			ticket.setBookings(booking);
			ticket.setUserId(dto.getUserId());
			ticket.setTravelDate(dto.getTravelDate());
			ticket.setTicketStatus("Booked");
			
			
			passanger.setPassangerName(dto.getPassangerName());
			passanger.setPassangerMobile(dto.getPassangerMobile());
			passanger.setPassangerEmail(dto.getPassangerEmail());
			passanger.setPassangerAddress(dto.getPassangerAddress());
			passanger.setTicket(ticket);
			passanger.setBookings(booking);
			
			totalFare=totalFare+ticket.getFare();
			
				
			ticketList.add(ticket);
			passangerList.add(passanger);
		}
		
		
		User user=bookingsService.findUserById(userId);
		
		booking.setTotalFare(totalFare);
		booking.setPassanger(passangerList);
		booking.setTicket(ticketList);
		booking.setUser(user);
		bookingsService.bookATicket(booking);
		
		return booking.getBookingId();
	}
	
	@RequestMapping("searchflight/{sou}/{dest}")
	public List<Flight> searchFlight(@PathVariable("sou") String source,@PathVariable("dest") String destination) {
		//DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM-dd-yyyy");
		List<Flight> flights=bookingsService.searchFlight(source, destination);
		return flights;
	}
	
	@RequestMapping("checkSeat/{fid}/{seatNo}/{tdate}")
	public boolean checkSeat(@PathVariable("fid") long flightId,@PathVariable("seatNo") long seatNo,@PathVariable("tdate") String travelDate ) {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM-dd-yyyy");
		long number=bookingsService.checkSeat(LocalDate.parse(travelDate,formatter), flightId, seatNo);
		if(number==0) {
			return true;
		}
		return false;
	}
	
	@RequestMapping("seatAvailable/{tdate}/{fid}")
	public long seatAvailable(@PathVariable("fid") long flightId,@PathVariable("tdate") String travelDate ) {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM-dd-yyyy");
		long number=bookingsService.numberOfSeatsAvailable(LocalDate.parse(travelDate,formatter), flightId);
		return number;
	}
	
	@RequestMapping("seatsUnavailable/{tdate}/{fid}")
	public List<Long> seatsNotAvailable(@PathVariable("fid") long flightId,@PathVariable("tdate") String travelDate ) {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM-dd-yyyy");
		List<Long>seats=bookingsService.seatsNotAvailable(LocalDate.parse(travelDate,formatter), flightId);
		return seats;
	}


	

}
