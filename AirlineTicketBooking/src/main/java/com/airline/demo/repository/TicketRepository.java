package com.airline.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.airline.demo.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "select * from ticket where flight_details_id = (:flight_details_id)", nativeQuery = true)
	List<Ticket> findAllByFlightDetailsId(@Param("flight_details_id") Long flight_details_id);
	
}
