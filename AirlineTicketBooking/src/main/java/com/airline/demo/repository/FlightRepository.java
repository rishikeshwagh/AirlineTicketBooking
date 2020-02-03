package com.airline.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.airline.demo.model.Flight;
import com.airline.demo.model.UserProfile;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value = "select * from flight where from_location = LOWER(:from_location)", nativeQuery = true)
	List<Flight> findByFromLocation(@Param("from_location") String from_location);

	@Query(value = "select * from flight where to_location = LOWER(:to_location)", nativeQuery = true)
	List<Flight> findToLocation(@Param("to_location") String to_location);

	@Query(value = "select * from flight where from_location = LOWER(:from_location) AND to_location = LOWER(:to_location) ", nativeQuery = true)
	List<Flight> findFromAndToLocation(@Param("from_location") String from_location,@Param("to_location") String to_location);

	@Query(value = "select * from user_profile where user_id = (:user_id)", nativeQuery = true)
	UserProfile findByUserId(@Param("user_id") long user_id);
}
