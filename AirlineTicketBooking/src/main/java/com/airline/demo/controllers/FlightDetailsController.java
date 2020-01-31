package com.airline.demo.controllers;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.FlightDetails;
import com.airline.demo.service.FlightDetailsService;

@RestController
public class FlightDetailsController {

	@Autowired
	FlightDetailsService flightDetailsService;

//	@PutMapping("/updateflightprice")
//	public ResponseEntity<FlightDetails> updateFlightPrice(@Valid @RequestBody FlightDetails flightDetails)
//			throws ResourceNotFoundException {
//		return flightDetailsService.updateFlightPrice(flightDetails);
//	}
	
	@PutMapping("/updateflightprice")
	public ResponseEntity<FlightDetails> updateFlightPrice( @RequestBody Long flightId,@RequestBody Date flightDepartureDate,@RequestBody int price)
			throws ResourceNotFoundException {
		return flightDetailsService.updateFlightPrice(flightId, flightDepartureDate, price);
	}

	@PutMapping("/updateavailableseats")
	public ResponseEntity<FlightDetails> updateAvailableSeats(@Valid @RequestBody FlightDetails flightDetails)
			throws ResourceNotFoundException {
		return flightDetailsService.updateAvailableSeats(flightDetails);
	}
	
	@PutMapping("/updateflightdeparturetime")
	public ResponseEntity<FlightDetails> updateFlightDepartureTime(@Valid @RequestBody FlightDetails flightDetails)
			throws ResourceNotFoundException {
		return flightDetailsService.updateFlightDepartureTime(flightDetails);
	}
	@PostMapping("/fillflightdetails")
	public FlightDetails fillFlightDetails(@Valid @RequestBody FlightDetails flightDetails)
			throws ResourceNotFoundException {
		return flightDetailsService.fillFlightDetails(flightDetails);
	}
}
