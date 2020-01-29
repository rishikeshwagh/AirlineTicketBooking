package com.airline.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@PutMapping("/updateflightprice")
	public ResponseEntity<FlightDetails> updateFlightPrice(@Valid @RequestBody FlightDetails flightDetails)
			throws ResourceNotFoundException {
		return flightDetailsService.updateFlightDetails(flightDetails);
	}

}
