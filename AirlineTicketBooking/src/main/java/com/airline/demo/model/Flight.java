package com.airline.demo.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_id")
	public long flight_id;

	@Column(name = "airline_id", unique = true)
	public int airline_id;

	@Column(name = "airline_name")
	public String airline_name;

	@Column(name = "from_location")
	public String from_location;

	@Column(name = "to_location")
	public String to_location;

	@Column(name = "departure_time")
	public Time departure_time;

	@Column(name = "arrival_time")
	public Time arrival_time;

	@Column(name = "total_seats")
	public int total_seats;

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

	public int getTotal_seats() {
		return total_seats;
	}

	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	public Flight() {
		super();
	}

	public Flight(Long flight_id, int airline_id, String airline_name, String from_location, String to_location,
			Time departure_time, Time arrival_time, int total_seats) {
		super();
		this.flight_id = flight_id;
		this.airline_id = airline_id;
		this.airline_name = airline_name;
		this.from_location = from_location;
		this.to_location = to_location;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.total_seats = total_seats;
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", airline_id=" + airline_id + ", airline_name=" + airline_name
				+ ", from_location=" + from_location + ", to_location=" + to_location + ", departure_time="
				+ departure_time + ", arrival_time=" + arrival_time + ", total_seats=" + total_seats + "]";
	}

}
