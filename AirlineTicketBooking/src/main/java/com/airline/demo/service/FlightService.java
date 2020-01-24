package com.airline.demo.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.airline.demo.model.Flight;
import com.airline.demo.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	public FlightRepository flightRepository;


	public Flight registerFlight(Flight flight) {
		return flightRepository.save(flight);

	}

}
