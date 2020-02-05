package com.airline.demo.dto;

import java.util.List;

import com.airline.demo.model.Passenger;

public class TicketInfoRequest {
	public long user_id;
	public long flight_details_id;
	public List<Passenger> passengerslist;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getFlight_details_id() {
		return flight_details_id;
	}

	public void setFlight_details_id(long flight_details_id) {
		this.flight_details_id = flight_details_id;
	}

	public List<Passenger> getPassengerslist() {
		return passengerslist;
	}

	public void setPassengerslist(List<Passenger> passengerslist) {
		this.passengerslist = passengerslist;
	}

	public TicketInfoRequest(long user_id, long flight_details_id, List<Passenger> passengerslist) {
		super();
		this.user_id = user_id;
		this.flight_details_id = flight_details_id;
		this.passengerslist = passengerslist;
	}

	@Override
	public String toString() {
		return "TicketInfoDTO [user_id=" + user_id + ", flight_details_id=" + flight_details_id + ", passengerslist="
				+ passengerslist + "]";
	}

}
