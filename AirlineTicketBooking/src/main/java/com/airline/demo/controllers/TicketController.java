package com.airline.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.dto.TicketInfoRequest;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Passenger;
import com.airline.demo.model.Ticket;
import com.airline.demo.service.TicketService;
@RequestMapping("/airlineticketbooking")
@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/viewalltickets")
	public List<Ticket> getAllTickets() {
		return ticketService.getAllTickets();

	}

	@GetMapping("/viewticketbyid/{ticket_id}")
	public Optional<Ticket> getTicketById(@PathVariable Long ticket_id) {
		return ticketService.getTicketById(ticket_id);

	}

	@PostMapping("/generateticket")
	public @ResponseBody List<Passenger> generateTicket(@RequestBody TicketInfoRequest ticketInfoRequest)
			throws ResourceNotFoundException {
		return ticketService.generateTicket(ticketInfoRequest);

	}

}
