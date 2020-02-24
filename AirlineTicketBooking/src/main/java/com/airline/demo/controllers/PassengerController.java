package com.airline.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Passenger;
import com.airline.demo.service.PassengerService;

@RequestMapping("/airlineticketbooking")
@RestController
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	@GetMapping("/viewallpassengersbyticketid/{ticket_id}")
	public ResponseEntity<List<Passenger>> getAllPassengersByTicketId(@PathVariable(value = "ticket_id") Long ticket_id)
			throws ResourceNotFoundException {
		return passengerService.getAllPassengersByTicketId(ticket_id);
	}

	@PostMapping("/viewallpassengersbyflightidanddeparturedate/{flight_details_id}")
	public ResponseEntity<List<Passenger>> getAllPassengersByFlightIdAndDepartureDate(
			@PathVariable(value = "flight_details_id") Long flight_details_id) throws ResourceNotFoundException {
		return passengerService.getAllPassengersByFlightIdAndDepartureDate(flight_details_id);
	}

	@PostMapping("/viewallbookedseatsbyflightidanddeparturedate/{flight_details_id}")
	public ResponseEntity<List<Integer>> getAllBookedSeatsByFlightIdAndDepartureDate(
			@PathVariable(value = "flight_details_id") Long flight_details_id) throws ResourceNotFoundException {
		return passengerService.getAllBookedSeatsByFlightIdAndDepartureDate(flight_details_id);
	}
}
