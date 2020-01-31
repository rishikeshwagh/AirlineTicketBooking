package com.airline.demo.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.airline.demo.model.Passenger;

public class GeneratedTicketDTO {

	public long flight_id;

	public int airline_id;

	public String airline_name;

	public String from_location;

	public String to_location;

	public Time departure_time;

	public Time arrival_time;

	public Date flight_departure_date;

	public long price;

	public List<Passenger> passengerslist;

	public long ticket_id;

	public String ticket_status;

	public long user_id;

	public String user_first_name;

	public String user_last_name;

	public String user_address;

	public long user_mobile_number;

	public String user_email_id;

	public long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(long flight_id) {
		this.flight_id = flight_id;
	}

	public int getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}

	public String getFrom_location() {
		return from_location;
	}

	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}

	public String getTo_location() {
		return to_location;
	}

	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}

	public Time getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}

	public Time getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(Time arrival_time) {
		this.arrival_time = arrival_time;
	}

	public Date getFlight_departure_date() {
		return flight_departure_date;
	}

	public void setFlight_departure_date(Date flight_departure_date) {
		this.flight_departure_date = flight_departure_date;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public List<Passenger> getPassengerslist() {
		return passengerslist;
	}

	public void setPassengerslist(List<Passenger> passengerslist) {
		this.passengerslist = passengerslist;
	}

	public String getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
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

	@Override
	public String toString() {
		return "GeneratedTicketDTO [flight_id=" + flight_id + ", airline_id=" + airline_id + ", airline_name="
				+ airline_name + ", from_location=" + from_location + ", to_location=" + to_location
				+ ", departure_time=" + departure_time + ", arrival_time=" + arrival_time + ", flight_departure_date="
				+ flight_departure_date + ", price=" + price + ", passengerslist=" + passengerslist + ", ticket_status="
				+ ticket_status + ", ticket_id=" + ticket_id + ", user_id=" + user_id + ", user_first_name="
				+ user_first_name + ", user_last_name=" + user_last_name + ", user_address=" + user_address
				+ ", user_mobile_number=" + user_mobile_number + ", user_email_id=" + user_email_id + "]";
	}

}
