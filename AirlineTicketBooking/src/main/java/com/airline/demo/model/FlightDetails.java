package com.airline.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "flight_details")
public class FlightDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_details_id")
	public long flight_details_id;

	@Column(name = "flight_departure_date")
	public Date flight_departure_date;

	@Column(name = "price")
	public int price;

	@Column(name = "available_seats")
	public int available_seats;

	@ManyToOne
	@JoinColumn(name = "flight_id", nullable =false,foreignKey = @ForeignKey(name = "flight_id_fk"))
	
	public Flight flight;

	public long getFlight_details_id() {
		return flight_details_id;
	}

	public void setFlight_details_id(long flight_details_id) {
		this.flight_details_id = flight_details_id;
	}

	public Date getFlight_departure_date() {
		return flight_departure_date;
	}

	public void setFlight_departure_date(Date flight_departure_date) {
		this.flight_departure_date = flight_departure_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public FlightDetails() {
		super();
	}

	public FlightDetails(Long flight_details_id, Date flight_departure_date, int price, int available_seats,
			Flight flight) {
		super();
		this.flight_details_id = flight_details_id;
		this.flight_departure_date = flight_departure_date;
		this.price = price;
		this.available_seats = available_seats;
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "FlightDetails [flight_details_id=" + flight_details_id + ", flight_departure_date="
				+ flight_departure_date + ", price=" + price + ", available_seats=" + available_seats + ", flight="
				+ flight + "]";
	}

	

	
}
