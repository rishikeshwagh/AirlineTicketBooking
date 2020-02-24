package com.airline.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.UserProfile;
import com.airline.demo.service.LoginService;
@RequestMapping("/airlineticketbooking")
@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public boolean getLoginDetails(@RequestBody UserProfile loginuserprofile) throws ResourceNotFoundException {

		return loginService.getLoginDetails(loginuserprofile);
	}
}
