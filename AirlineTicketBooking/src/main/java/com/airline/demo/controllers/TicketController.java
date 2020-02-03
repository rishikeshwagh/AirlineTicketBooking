package com.airline.demo.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.dto.TicketInfoDTO;
import com.airline.demo.exception.ResourceNotFoundException;
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
	public @ResponseBody List<Passenger> generateTicket(@RequestBody TicketInfoDTO ticketInfoDTO) throws ResourceNotFoundException {
		System.out.println("generateticket");
		return ticketService.generateTicket(ticketInfoDTO);

	}

}
