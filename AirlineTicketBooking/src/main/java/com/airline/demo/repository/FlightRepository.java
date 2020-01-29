package com.airline.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.airline.demo.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value = "select * from flight where from_location = LOWER(:from_location)", nativeQuery = true)
	List<Flight> findByFromLocation(@Param("from_location") String from_location);

}
