package com.airline.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airline.demo.exception.ResourceNotFoundException;

import com.airline.demo.model.UserProfile;
import com.airline.demo.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean getLoginDetails(UserProfile loginuserprofile) throws ResourceNotFoundException {

		long loginuserid = loginuserprofile.getUser_id();
		String loginpassword = loginuserprofile.getPassword();

		UserProfile dbuserprofile = userRepository.findById(loginuserid).orElseThrow(
				() -> new ResourceNotFoundException("No User found with User Id ::  " + loginuserid + " "));

		Long dbuserid = dbuserprofile.getUser_id();
		String dbpassword = dbuserprofile.getPassword();
		boolean isvaliduser = false;

		if (dbuserprofile != null && dbuserid == loginuserid && loginpassword.equals(dbpassword)) {
			isvaliduser = true;
		} else if (dbuserprofile != null && dbuserid == loginuserid) {

			throw new ResourceNotFoundException("Wrong Password for User  with User Id ::  " + loginuserid + " ");

		}

		return isvaliduser;
	}

}
