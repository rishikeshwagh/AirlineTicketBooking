package com.airline.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.airline.demo.model.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {

	@Query(value = "select * from flight_details where flight_id=(:flight_id) and flight_departure_date =(:flight_departure_date)", nativeQuery = true)
	FlightDetails findByIdAndFlightDepartureDate(@Param("flight_id") Long flight_id,
			@Param("flight_departure_date") Date flight_departure_date);

	@Query(value = "select * from flight_details where flight_details_id = (:flight_details_id)", nativeQuery = true)
	FlightDetails findByFlightDetailsId(@Param("flight_details_id") long flight_details_id);

	@Query(value = "select p.passernger_seat_number from flight_details fd,ticket t, passenger p \r\n" + "where\r\n"
			+ "fd.flight_details_id = t.flight_details_id\r\n" + "AND t.ticket_id = p.ticket_id\r\n"
			+ "AND fd.flight_details_id =(:flight_details_id)", nativeQuery = true)
	List<Integer> findAllAvailableSeats(@Param("flight_details_id") Long flight_details_id);

	@Query(value = "SELECT * FROM flight_details where flight_id =(:flight_id) AND flight_departure_date =(:flight_departure_date)", nativeQuery = true)
	FlightDetails findflightDetailsByFlightId(@Param("flight_id") Long flight_id,@Param("flight_departure_date") Date flight_departure_date);

}
