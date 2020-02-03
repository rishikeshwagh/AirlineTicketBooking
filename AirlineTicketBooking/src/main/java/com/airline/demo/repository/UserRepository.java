package com.airline.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.airline.demo.model.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
	@Query(value = "select * from user_profile where user_id = (:user_id)", nativeQuery = true)
	UserProfile findByUserId(@Param("user_id") long user_id);
}
