package com.airline.demo.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.model.Flight;
import com.airline.demo.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	public FlightService flightService;



	@PostMapping("/registerflight")
	Flight registerFlight(@Valid @RequestBody Flight flight) {
		return flightService.registerFlight(flight);
	}

}
