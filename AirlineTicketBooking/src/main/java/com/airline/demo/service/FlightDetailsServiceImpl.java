package com.airline.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airline.demo.dto.SearchDTO;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.Flight;
import com.airline.demo.model.FlightDetails;
import com.airline.demo.repository.FlightDetailsRepository;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired
	FlightDetailsRepository flightDetailsRepository;
	@Autowired
	FlightServiceImpl flightService;

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

	public List<FlightDetails> getCheaperFlightsFromAndToLocation(@Valid SearchDTO searchDTO)
			throws ResourceNotFoundException {
		List<FlightDetails> flightdetailslist = new ArrayList<FlightDetails>();

		String to_location = searchDTO.getTo_location();
		Date flight_departure_date = searchDTO.getFlight_departure_date();
		String from_location = searchDTO.getFrom_location();
		List<Flight> flights = flightService.getFlightFromAndToLocation(from_location, to_location);

		for (int i = 0; i < flights.size(); i++) {
			FlightDetails flightDetails = new FlightDetails();
			flightDetails = flightDetailsRepository.findflightDetailsByFlightId(flights.get(i).getFlight_id(),
					flight_departure_date);
			if(flightDetails!=null) {
			flightdetailslist.add(flightDetails);}
		}
		Collections.sort(flightdetailslist, new Comparator<FlightDetails>() {
			public int compare(FlightDetails flightdetailslist1, FlightDetails flightdetailslist2) {

				return Integer.valueOf(flightdetailslist1.getPrice()).compareTo(Integer.valueOf(flightdetailslist2.getPrice()));
			}
		});
		return flightdetailslist;
	}

	
}
