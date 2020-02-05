package com.airline.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.UserProfile;
import com.airline.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	public UserProfile registerUserProfile(UserProfile userProfile) {

		return userRepository.save(userProfile);
	}

	public ResponseEntity<UserProfile> updateUser(Long user_id, UserProfile newuser) throws ResourceNotFoundException {
		UserProfile userProfile = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this user_id :: " + user_id));
		userProfile.setPassword(newuser.getPassword());
		userProfile.setUser_first_name(newuser.getUser_first_name());
		userProfile.setUser_last_name(newuser.getUser_last_name());
		userProfile.setUser_address(newuser.getUser_address());
		userProfile.setUser_mobile_number(newuser.getUser_mobile_number());
		userProfile.setUser_email_id(newuser.getUser_email_id());

		final UserProfile updateduser = userRepository.save(userProfile);
		return ResponseEntity.ok(updateduser);

	}

	public List<UserProfile> getAllUsers() {

		return userRepository.findAll();
	}

	public ResponseEntity<UserProfile> getUserByUserId(Long user_id) throws ResourceNotFoundException {

		UserProfile userProfile = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + user_id));
		return ResponseEntity.ok().body(userProfile);
	}

	public Map<String, Boolean> deleteUser(Long user_id) throws ResourceNotFoundException {
		UserProfile userProfile = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this User Id :: " + user_id));
		userRepository.delete(userProfile);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted User with User Id :: " + user_id + "   And User Name ::"
				+ userProfile.getUser_first_name(), Boolean.TRUE);
		return response;
	}

}
