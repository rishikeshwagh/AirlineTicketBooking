package com.airline.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Flight;

public interface FlightService {

	Flight registerFlight(Flight flight);

	Map<String, Boolean> deleteFlight(Long flight_id) throws ResourceNotFoundException;

	ResponseEntity<Flight> updateFlight(Long flight_id, Flight newflight) throws ResourceNotFoundException;

	List<Flight> getAllFlights();

	ResponseEntity<Flight> getFlightByFlightId(Long flight_id) throws ResourceNotFoundException;

	List<Flight> getFlightByFromLocation(String from_location) throws ResourceNotFoundException;

	List<Flight> getFlightToLocation(String to_location) throws ResourceNotFoundException;

	List<Flight> getFlightFromAndToLocation(String from_location, String to_location) throws ResourceNotFoundException;
}
