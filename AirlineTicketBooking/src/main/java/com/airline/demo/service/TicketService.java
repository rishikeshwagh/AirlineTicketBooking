package com.airline.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airline.demo.dto.TicketInfoDTO;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.FlightDetails;
import com.airline.demo.model.Passenger;
import com.airline.demo.model.Ticket;
import com.airline.demo.model.UserProfile;
import com.airline.demo.repository.FlightDetailsRepository;
import com.airline.demo.repository.PassengerRepository;
import com.airline.demo.repository.TicketRepository;
import com.airline.demo.repository.UserRepository;

@Service
public class TicketService {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public Optional<Ticket> getTicketById(long ticket_id) {

		return ticketRepository.findById(ticket_id);
	}

	public List<Passenger> generateTicket(TicketInfoDTO ticketInfoDTO) throws ResourceNotFoundException {

		long user_id = ticketInfoDTO.getUser_id();
		long flight_details_id = ticketInfoDTO.getFlight_details_id();
		List<Passenger> passengerslist = ticketInfoDTO.getPassengerslist();
		
		if (passengerslist == null) {
			throw new ResourceNotFoundException("No Passengers Added: ADD Passengers First");
		}
		
		UserProfile userProfile = userRepository.findByUserId(user_id);
		FlightDetails flightDetails = flightDetailsRepository.findByFlightDetailsId(flight_details_id);

		Ticket ticket = new Ticket();
		ticket.setUserProfile(userProfile);
		ticket.setFlightDetails(flightDetails);
		ticket.setTicket_status("PENDING");

		ticketRepository.save(ticket);

		for (int i = 0; i < passengerslist.size(); i++) {
			Passenger passenger = passengerslist.get(i);
			passenger.setTicket(ticket);
		}

		passengerRepository.saveAll(passengerslist);
		ticket.setTicket_status("BOOKED");
		ticketRepository.save(ticket);
		List<Passenger> bookedpassengerslist = passengerRepository.findAllByTicketId(ticket.getTicket_id());

		return bookedpassengerslist;

	}

}
