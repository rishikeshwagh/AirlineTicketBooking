package com.airline.demo.service;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.FlightDetails;
import com.airline.demo.model.Passenger;
import com.airline.demo.model.Ticket;
import com.airline.demo.repository.FlightDetailsRepository;
import com.airline.demo.repository.PassengerRepository;
import com.airline.demo.repository.TicketRepository;

@Service
public class PassengerService {
	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	@Autowired
	TicketRepository ticketRepository;

	private List<Long> ticketidlist;
	public List<Passenger> passengerlist = null;

	public List<Passenger> addPassengers(@Valid List<Passenger> passengerslist) {
		return passengerRepository.saveAll(passengerslist);
	}

	public ResponseEntity<List<Passenger>> getAllPassengersByTicketId(Long ticket_id) throws ResourceNotFoundException {
		List<Passenger> passengerlist = passengerRepository.findAllByTicketId(ticket_id);
		if (passengerlist == null)
			new ResourceNotFoundException("No Passenger found for this id :: " + ticket_id);
		return ResponseEntity.ok().body(passengerlist);
	}

	public ResponseEntity<List<Passenger>> getAllPassengersByFlightIdAndDepartureDate(long flight_id,
			Date flight_departure_date) {

		FlightDetails flightdetails = flightDetailsRepository.findByIdAndFlightDepartureDate(flight_id,
				flight_departure_date);

		List<Ticket> ticketslist = ticketRepository.findAllByFlightDetailsId(flightdetails.getFlight_details_id());

		for (int i = 0; i <= ticketslist.size(); i++) {
			ticketidlist.add(ticketslist.get(i).getTicket_id());
		}

		for (int j = 0; j <= ticketidlist.size(); j++) {
			passengerlist.addAll(passengerRepository.findAllByTicketId(ticketidlist.get(j)));
		}

		return ResponseEntity.ok().body(passengerlist);
	}

}
