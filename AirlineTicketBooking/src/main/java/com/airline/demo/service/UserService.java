package com.airline.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.UserProfile;

public interface UserService {

	public UserProfile registerUserProfile(UserProfile userProfile);

	public ResponseEntity<UserProfile> updateUser(Long user_id, UserProfile newuser) throws ResourceNotFoundException;

	public List<UserProfile> getAllUsers();

	public ResponseEntity<UserProfile> getUserByUserId(Long user_id) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteUser(Long user_id) throws ResourceNotFoundException;

}
