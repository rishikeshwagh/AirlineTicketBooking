package com.airline.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.demo.model.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {

}






