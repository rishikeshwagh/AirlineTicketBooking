package com.airline.demo.service;

import java.util.List;
import java.util.Optional;

import com.airline.demo.dto.TicketInfoRequest;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Passenger;
import com.airline.demo.model.Ticket;

public interface TicketService {
	
	public List<Ticket> getAllTickets();

	public Optional<Ticket> getTicketById(long ticket_id);

	public List<Passenger> generateTicket(TicketInfoRequest ticketInfoRequest) throws ResourceNotFoundException;

}
