package com.airline.demo.dto;

import java.sql.Date;

public class SearchDTO {
	String to_location;
	Date flight_departure_date;
	String from_location;

	public String getTo_location() {
		return to_location;
	}

	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}

	public Date getFlight_departure_date() {
		return flight_departure_date;
	}

	public void setFlight_departure_date(Date flight_departure_date) {
		this.flight_departure_date = flight_departure_date;
	}

	public String getFrom_location() {
		return from_location;
	}

	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}

	public SearchDTO(String to_location, Date flight_departure_date, String from_location) {
		super();
		this.to_location = to_location;
		this.flight_departure_date = flight_departure_date;
		this.from_location = from_location;
	}

	@Override
	public String toString() {
		return "SearchDTO [to_location=" + to_location + ", flight_departure_date=" + flight_departure_date
				+ ", from_location=" + from_location + "]";
	}

}
