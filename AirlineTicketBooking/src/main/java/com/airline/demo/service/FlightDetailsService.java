package com.airline.demo.service;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airline.demo.exception.ResourceNotFoundException;

import com.airline.demo.model.FlightDetails;
import com.airline.demo.repository.FlightDetailsRepository;

@Service
public class FlightDetailsService {

	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	public ResponseEntity<FlightDetails> updateFlightDetails(@Valid FlightDetails newflightdetails)
			throws ResourceNotFoundException {
		Long myflight_id = newflightdetails.getFlight().getFlight_id();
		Date mydate = newflightdetails.getFlight_departure_date();

		FlightDetails flightdetails = flightDetailsRepository.findByIdAndFlightDepartureDate(myflight_id, mydate);

		if (flightdetails == null) {

			new ResourceNotFoundException(
					"Flight Details not found for this flight_id :: " + newflightdetails.getFlight_details_id());

		}

		flightdetails.setPrice(newflightdetails.getPrice());
//		flightdetails.setFlight_departure_date(newflightdetails.getFlight_departure_date());

		final FlightDetails updatedflightdetails = flightDetailsRepository.save(flightdetails);
		return ResponseEntity.ok(updatedflightdetails);
	}
}
