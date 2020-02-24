package com.airline.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.dto.SearchDTO;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.FlightDetails;
import com.airline.demo.service.FlightDetailsService;

@RequestMapping("/airlineticketbooking")
@RestController
public class FlightDetailsController {

	@Autowired
	FlightDetailsService flightDetailsService;

	@PutMapping("/updateflightprice")
	public ResponseEntity<FlightDetails> updateFlightPrice(@RequestBody FlightDetails flightDetails)
			throws ResourceNotFoundException {
		return flightDetailsService.updateFlightPrice(flightDetails);
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

	@PostMapping("/getallavailableseats/{flight_details_id}")
	public List<Integer> getAllAvailableSeats(@PathVariable Long flight_details_id) throws ResourceNotFoundException {
		return flightDetailsService.getAllAvailableSeats(flight_details_id);
	}

	@PostMapping("/searchcheaperflightsfromandtolocation")
	public List<FlightDetails> getCheaperFlightsFromAndToLocation(@Valid @RequestBody SearchDTO searchDTO)
			throws ResourceNotFoundException {
		return flightDetailsService.getCheaperFlightsFromAndToLocation(searchDTO);
	}
	
	
}
