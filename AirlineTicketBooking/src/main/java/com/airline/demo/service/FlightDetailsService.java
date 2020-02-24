package com.airline.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.airline.demo.dto.SearchDTO;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.FlightDetails;

public interface FlightDetailsService {

	ResponseEntity<FlightDetails> updateFlightPrice(FlightDetails newflightDetails) throws ResourceNotFoundException;

	ResponseEntity<FlightDetails> updateAvailableSeats(@Valid FlightDetails newflightdetails)
			throws ResourceNotFoundException;

	ResponseEntity<FlightDetails> updateFlightDepartureTime(@Valid FlightDetails newflightdetails)
			throws ResourceNotFoundException;

	FlightDetails fillFlightDetails(@Valid FlightDetails flightDetails);

	List<Integer> getAllAvailableSeats(Long flight_details_id);

	public List<FlightDetails> getCheaperFlightsFromAndToLocation(@Valid SearchDTO searchDTO)
			throws ResourceNotFoundException;

}
