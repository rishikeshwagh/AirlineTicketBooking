package com.airline.demo.service;

import com.airline.demo.exception.ResourceNotFoundException;
import com.airline.demo.model.UserProfile;

public interface LoginService {
	boolean getLoginDetails(UserProfile userProfile) throws ResourceNotFoundException;
}
