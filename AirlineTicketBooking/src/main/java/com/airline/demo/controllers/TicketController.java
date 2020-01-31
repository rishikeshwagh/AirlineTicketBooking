package com.airline.demo.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.dto.GeneratedTicketDTO;
import com.airline.demo.model.Passenger;
import com.airline.demo.model.Ticket;
import com.airline.demo.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/viewalltickets")
	public List<Ticket> getAllTickets() {
		return ticketService.getAllTickets();

	}

	@GetMapping("/viewticketbyid")
	public Optional<Ticket> getTicketById(@RequestParam long ticket_id) {
		return ticketService.getTicketById(ticket_id);

	}

	@PostMapping("/generateticket")
	public GeneratedTicketDTO generateTicket(@RequestBody long user_id, @RequestBody long flight_details_id,
			@RequestBody @Valid List<Passenger> passengerslist) {
		return ticketService.generateTicket(user_id, flight_details_id, passengerslist);
	}

}
