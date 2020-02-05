package com.airline.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Passenger;

public interface PassengerService {

	public List<Passenger> addPassengers(@Valid List<Passenger> passengerslist);

	ResponseEntity<List<Passenger>> getAllPassengersByTicketId(Long ticket_id) throws ResourceNotFoundException;

	public ResponseEntity<List<Passenger>> getAllPassengersByFlightIdAndDepartureDate(Long flight_details_id);

	ResponseEntity<List<Integer>> getAllBookedSeatsByFlightIdAndDepartureDate(Long flight_details_id);

}
