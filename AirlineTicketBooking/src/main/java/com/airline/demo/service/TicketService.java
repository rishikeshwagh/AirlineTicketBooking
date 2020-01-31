package com.airline.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.demo.dto.GeneratedTicketDTO;
import com.airline.demo.model.FlightDetails;
import com.airline.demo.model.Passenger;
import com.airline.demo.model.Ticket;
import com.airline.demo.model.UserProfile;
import com.airline.demo.repository.PassengerRepository;
import com.airline.demo.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	PassengerRepository passengerRepository;
//	@Autowired
//	GeneratedTicketDTO generatedTicketDTO;

	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	public Optional<Ticket> getTicketById(long ticket_id) {

		return ticketRepository.findById(ticket_id);
	}

	public GeneratedTicketDTO generateTicket(long user_id, long flight_details_id, List<Passenger> passengerslist) {

		UserProfile userProfile = new UserProfile();
		userProfile.setUser_id(user_id);

		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setFlight_details_id(flight_details_id);

		Ticket ticket = new Ticket();
		ticket.setUserProfile(userProfile);
		ticket.setFlightDetails(flightDetails);

		ticketRepository.save(ticket);

		for (int i = 0; i <= passengerslist.size(); i++) {
			Passenger passenger = passengerslist.get(i);
			passenger.setTicket(ticket);
		}

		passengerRepository.saveAll(passengerslist);
		ticket.setTicket_status("booked");
		ticketRepository.save(ticket);
		List<Passenger> bookedpassengerlist = passengerRepository.findAllByTicketId(ticket.getTicket_id());
		GeneratedTicketDTO generatedTicketDTO = new GeneratedTicketDTO();
		generatedTicketDTO.setFlight_id(ticket.getFlightDetails().getFlight().getFlight_id());
		generatedTicketDTO.setAirline_id(ticket.getFlightDetails().getFlight().getAirline_id());
		generatedTicketDTO.setAirline_name(ticket.getFlightDetails().getFlight().getAirline_name());
		generatedTicketDTO.setFrom_location(ticket.getFlightDetails().getFlight().getFrom_location());
		generatedTicketDTO.setTo_location(ticket.getFlightDetails().getFlight().getTo_location());
		generatedTicketDTO.setArrival_time(ticket.getFlightDetails().getFlight().getArrival_time());
		generatedTicketDTO.setDeparture_time(ticket.getFlightDetails().getFlight().getDeparture_time());
		generatedTicketDTO.setFlight_departure_date(ticket.getFlightDetails().getFlight_departure_date());
		generatedTicketDTO.setPrice(ticket.getFlightDetails().getPrice());
		generatedTicketDTO.setPassengerslist(bookedpassengerlist);
		generatedTicketDTO.setTicket_id(ticket.getTicket_id());
		generatedTicketDTO.setTicket_status(ticket.getTicket_status());
		generatedTicketDTO.setUser_id(ticket.getUserProfile().getUser_id());
		generatedTicketDTO.setUser_first_name(ticket.getUserProfile().getUser_first_name());
		generatedTicketDTO.setUser_last_name(ticket.getUserProfile().getUser_last_name());
		generatedTicketDTO.setUser_address(ticket.getUserProfile().getUser_address());
		generatedTicketDTO.setUser_mobile_number(ticket.getUserProfile().getUser_mobile_number());
		generatedTicketDTO.setUser_email_id(ticket.getUserProfile().getUser_email_id());

		return generatedTicketDTO;

	}

}
