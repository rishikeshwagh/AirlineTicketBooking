package com.airline.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.UserProfile;
import com.airline.demo.service.UserService;

@RequestMapping("/airlineticketbooking")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/registeruser")
	public UserProfile registerUserProfile(@Valid @RequestBody UserProfile userProfile) {
		return userService.registerUserProfile(userProfile);

	}

	@GetMapping("/viewallusers")
	public List<UserProfile> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/viewuserbyuserid/{user_id}")
	public ResponseEntity<UserProfile> getUserByUserId(@PathVariable(value = "user_id") Long user_id)
			throws ResourceNotFoundException {

		return userService.getUserByUserId(user_id);
	}

	@PutMapping("/updateuser/{user_id}")
	public ResponseEntity<UserProfile> updateUser(@PathVariable(value = "user_id") Long user_id,
			@Valid @RequestBody UserProfile newuser) throws ResourceNotFoundException {

		return userService.updateUser(user_id, newuser);
	}

	@DeleteMapping("/deleteuser/{user_id}")
	Map<String, Boolean> deleteUser(@PathVariable(value = "user_id") Long user_id) throws ResourceNotFoundException {
		return userService.deleteUser(user_id);
	}
}
