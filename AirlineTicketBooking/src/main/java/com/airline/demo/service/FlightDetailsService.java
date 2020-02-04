package com.airline.demo.service;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Flight;
import com.airline.demo.model.FlightDetails;
import com.airline.demo.repository.FlightDetailsRepository;

@Service
public class FlightDetailsService {

	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	public ResponseEntity<FlightDetails> updateFlightPrice(FlightDetails newflightDetails)
			throws ResourceNotFoundException {
		FlightDetails oldflightdetails = new FlightDetails();
		Long flight_details_id = newflightDetails.getFlight_details_id();
		oldflightdetails = flightDetailsRepository.findByFlightDetailsId(flight_details_id);

		oldflightdetails.setPrice(newflightDetails.getPrice());

		final FlightDetails updatedflightdetails = flightDetailsRepository.save(oldflightdetails);
		return ResponseEntity.ok(updatedflightdetails);
	}

	public ResponseEntity<FlightDetails> updateAvailableSeats(@Valid FlightDetails newflightdetails)
			throws ResourceNotFoundException {
		Long myflight_id = newflightdetails.getFlight().getFlight_id();
		Date mydate = newflightdetails.getFlight_departure_date();

		FlightDetails flightdetails = flightDetailsRepository.findByIdAndFlightDepartureDate(myflight_id, mydate);

		if (flightdetails == null) {

			new ResourceNotFoundException(
					"Flight Details not found for this flight_id :: " + newflightdetails.getFlight_details_id());

		}

		flightdetails.setAvailable_seats(newflightdetails.getAvailable_seats());

		final FlightDetails updatedflightdetails = flightDetailsRepository.save(flightdetails);
		return ResponseEntity.ok(updatedflightdetails);
	}

	public ResponseEntity<FlightDetails> updateFlightDepartureTime(@Valid FlightDetails newflightdetails)
			throws ResourceNotFoundException {
		Long myflight_id = newflightdetails.getFlight().getFlight_id();
		Date mydate = newflightdetails.getFlight_departure_date();

		FlightDetails flightdetails = flightDetailsRepository.findByIdAndFlightDepartureDate(myflight_id, mydate);

		if (flightdetails == null) {

			new ResourceNotFoundException(
					"Flight Details not found for this flight_id :: " + newflightdetails.getFlight_details_id());

		}
		Flight rishiflight = flightdetails.getFlight();
		rishiflight.setDeparture_time(newflightdetails.getFlight().getDeparture_time());
		flightdetails.setFlight(rishiflight);

		final FlightDetails updatedflightdetails = flightDetailsRepository.save(flightdetails);
		return ResponseEntity.ok(updatedflightdetails);
	}

	public FlightDetails fillFlightDetails(@Valid FlightDetails flightDetails) {

		return flightDetailsRepository.save(flightDetails);

	}

	public List<Integer> getAllAvailableSeats(Long flight_details_id) {

		return flightDetailsRepository.findAllAvailableSeats(flight_details_id);
	}
}
