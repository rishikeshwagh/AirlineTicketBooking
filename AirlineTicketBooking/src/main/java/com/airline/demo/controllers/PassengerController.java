package com.airline.demo.controllers;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Passenger;
import com.airline.demo.service.PassengerService;

@RestController
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	@PostMapping("/viewallpassengersbyticketid/{ticket_id}")
	public ResponseEntity<List<Passenger>> getAllPassengersByTicketId(@RequestParam long ticket_id)
			throws ResourceNotFoundException {
		return passengerService.getAllPassengersByTicketId(ticket_id);
	}

	@PostMapping("/viewallpassengersbyflightidanddeparturedate")
	public ResponseEntity<List<Passenger>> getAllPassengersByFlightIdAndDepartureDate(@RequestBody long flight_id,
			@RequestBody Date flight_departure_date) throws ResourceNotFoundException {
		return passengerService.getAllPassengersByFlightIdAndDepartureDate(flight_id, flight_departure_date);
	}
}
