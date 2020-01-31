package com.airline.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "user_profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public long user_id;

	@Column(name = "password" )
	public String password;

	@Column(name = "user_first_name")
	public String user_first_name;

	@Column(name = "user_last_name")
	public String user_last_name;

	@Column(name = "user_address")
	public String user_address;

	@Column(name = "user_mobile_number")
	public long user_mobile_number;

	@Column(name = "user_email_id",unique =true)
	public String user_email_id;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public long getUser_mobile_number() {
		return user_mobile_number;
	}

	public void setUser_mobile_number(long user_mobile_number) {
		this.user_mobile_number = user_mobile_number;
	}

	public String getUser_email_id() {
		return user_email_id;
	}

	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}

	public UserProfile() {
		super();
	}

	public UserProfile(Long user_id, String password, String user_first_name, String user_last_name, String user_address,
			long user_mobile_number, String user_email_id) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_address = user_address;
		this.user_mobile_number = user_mobile_number;
		this.user_email_id = user_email_id;
	}

	@Override
	public String toString() {
		return "UserProfile [user_id=" + user_id + ", password=" + password + ", user_first_name=" + user_first_name
				+ ", user_last_name=" + user_last_name + ", user_address=" + user_address + ", user_mobile_number="
				+ user_mobile_number + ", user_email_id=" + user_email_id + "]";
	}

}
