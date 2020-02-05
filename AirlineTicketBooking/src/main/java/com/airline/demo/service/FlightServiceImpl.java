package com.airline.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Flight;
import com.airline.demo.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	public FlightRepository flightRepository;

	public Flight registerFlight(Flight flight) {
		return flightRepository.save(flight);

	}

	public Map<String, Boolean> deleteFlight(Long flight_id) throws ResourceNotFoundException {
		Flight flight = flightRepository.findById(flight_id).orElseThrow(
				() -> new ResourceNotFoundException("Flight not found for this Flight Id :: " + flight_id));
		flightRepository.delete(flight);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted flight with Flight Id ::" + flight_id, Boolean.TRUE);
		return response;
	}

	public ResponseEntity<Flight> updateFlight(Long flight_id, Flight newflight) throws ResourceNotFoundException {
		Flight flight = flightRepository.findById(flight_id).orElseThrow(
				() -> new ResourceNotFoundException("Flight not found for this flight_id :: " + flight_id));
		flight.setAirline_id(newflight.getAirline_id());
		flight.setAirline_name(newflight.getAirline_name());
		flight.setFrom_location(newflight.getFrom_location());
		flight.setTo_location(newflight.getTo_location());
		flight.setDeparture_time(newflight.getDeparture_time());
		flight.setArrival_time(newflight.getArrival_time());
		flight.setTotal_seats(newflight.getTotal_seats());

		final Flight updatedFlight = flightRepository.save(flight);
		return ResponseEntity.ok(updatedFlight);
	}

	public List<Flight> getAllFlights() {

		return flightRepository.findAll();
	}

	public ResponseEntity<Flight> getFlightByFlightId(Long flight_id) throws ResourceNotFoundException {

		Flight flight = flightRepository.findById(flight_id)
				.orElseThrow(() -> new ResourceNotFoundException("Flight not found for this id :: " + flight_id));
		return ResponseEntity.ok().body(flight);
	}

	public List<Flight> getFlightByFromLocation(String from_location) throws ResourceNotFoundException {
		List<Flight> flight = flightRepository.findByFromLocation(from_location);
		return flight;
	}
	public List<Flight> getFlightToLocation(String to_location) throws ResourceNotFoundException {
		List<Flight> flight = flightRepository.findToLocation(to_location);
		return flight;
	}
	public List<Flight> getFlightFromAndToLocation(String from_location,String to_location) throws ResourceNotFoundException {
		List<Flight> flight = flightRepository.findFromAndToLocation(from_location, to_location);
		return flight;
	}
}
