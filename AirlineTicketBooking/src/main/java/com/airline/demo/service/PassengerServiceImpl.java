package com.airline.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Passenger;
import com.airline.demo.model.Ticket;
import com.airline.demo.repository.FlightDetailsRepository;
import com.airline.demo.repository.PassengerRepository;
import com.airline.demo.repository.TicketRepository;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	@Autowired
	TicketRepository ticketRepository;

	private List<Long> ticketidlist = new ArrayList<Long>();
	public List<Passenger> passengerlist = new ArrayList<Passenger>();
	List<Integer> availableseatnumberslist = new ArrayList<Integer>();

	public List<Passenger> addPassengers(@Valid List<Passenger> passengerslist) {
		return passengerRepository.saveAll(passengerslist);
	}

	public ResponseEntity<List<Passenger>> getAllPassengersByTicketId(Long ticket_id) throws ResourceNotFoundException {
		List<Passenger> passengerlist = passengerRepository.findAllByTicketId(ticket_id);
		if (passengerlist == null)
			new ResourceNotFoundException("No Passenger found for this id :: " + ticket_id);
		return ResponseEntity.ok().body(passengerlist);
	}

	public ResponseEntity<List<Passenger>> getAllPassengersByFlightIdAndDepartureDate(Long flight_details_id) {

		List<Ticket> ticketslist = ticketRepository.findAllByFlightDetailsId(flight_details_id);

		for (int i = 0; i < ticketslist.size(); i++) {
			ticketidlist.add(ticketslist.get(i).getTicket_id());
		}

		for (int j = 0; j < ticketidlist.size(); j++) {
			passengerlist.addAll(passengerRepository.findAllByTicketId(ticketidlist.get(j)));
		}

		return ResponseEntity.ok().body(passengerlist);
	}

	public ResponseEntity<List<Integer>> getAllBookedSeatsByFlightIdAndDepartureDate(Long flight_details_id) {

		List<Ticket> ticketslist = ticketRepository.findAllByFlightDetailsId(flight_details_id);

		for (int i = 0; i < ticketslist.size(); i++) {
			ticketidlist.add(ticketslist.get(i).getTicket_id());
		}

		for (int j = 0; j < ticketidlist.size(); j++) {
			passengerlist.addAll(passengerRepository.findAllByTicketId(ticketidlist.get(j)));
		}

		List<Integer> availableseatnumberslist = new ArrayList<Integer>();
		passengerlist.forEach(passenger -> {
			availableseatnumberslist.add(passenger.getPassernger_seat_number());
		});

		return ResponseEntity.ok().body(availableseatnumberslist);
	}
//use airline;
//select p.passernger_seat_number from flight_details fd,ticket t, passenger p 
//where
//fd.flight_details_id = t.flight_details_id
//AND t.ticket_id = p.ticket_id
//AND fd.flight_details_id =7
}
