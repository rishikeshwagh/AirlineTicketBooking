package com.airline.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Flight;
import com.airline.demo.service.FlightService;

@RequestMapping("/airlineticketbooking")
@RestController
public class FlightController {

	@Autowired
	public FlightService flightService;

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	@GetMapping("/flight/{flight_id}")
	public ResponseEntity<Flight> getFlightByFlightId(@PathVariable(value = "flight_id") Long flight_id)
			throws ResourceNotFoundException {
		return flightService.getFlightByFlightId(flight_id);

	}

	@PostMapping("/registerflight")
	Flight registerFlight(@Valid @RequestBody Flight flight) {
		return flightService.registerFlight(flight);
	}

	@DeleteMapping("/deleteflight/{flight_id}")
	Map<String, Boolean> deleteFlight(@PathVariable(value = "flight_id") Long flight_id)
			throws ResourceNotFoundException {
		return flightService.deleteFlight(flight_id);
	}

	@PutMapping("/updateflight/{flight_id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable(value = "flight_id") Long flight_id,
			@Valid @RequestBody Flight newflight) throws ResourceNotFoundException {
		return flightService.updateFlight(flight_id, newflight);
	}

	@GetMapping("/flightfromlocation/{from_location}")
	public List<Flight> getFlightByFromLocation(@PathVariable(value = "from_location") String from_location)
			throws ResourceNotFoundException {
		return flightService.getFlightByFromLocation(from_location);
	}

	@GetMapping("/flighttolocation/{to_location}")
	public List<Flight> getFlightToLocation(@PathVariable(value = "to_location") String to_location)
			throws ResourceNotFoundException {
		return flightService.getFlightToLocation(to_location);
	}

	@PostMapping("/searchflightfromandtolocation")
	public List<Flight> getFlightFromAndToLocation(@Valid @RequestBody Flight flight) throws ResourceNotFoundException {
		return flightService.getFlightFromAndToLocation(flight.getFrom_location(), flight.getTo_location());
	}

}
