package com.airline.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.airline.demo.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	
	@Query(value = "select * from passenger where ticket_id=(:ticket_id)", nativeQuery = true)
	List<Passenger> findAllByTicketId(@Param("ticket_id") Long ticket_id);

	

}
