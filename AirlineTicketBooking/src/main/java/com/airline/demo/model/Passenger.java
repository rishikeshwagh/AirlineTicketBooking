package com.airline.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	public long passenger_id;

	@Column(name = "passernger_first_name")
	public String passernger_first_name;

	@Column(name = "passernger_last_name")
	public String passernger_last_name;

	@Column(name = "passernger_age")
	public int passernger_age;

	@Column(name = "passernger_gender")
	public String passernger_gender;

	@Column(name = "passernger_seat_number")
	public int passernger_seat_number;

	@ManyToOne
	@JoinColumn(name = "ticket_id", nullable =false,foreignKey = @ForeignKey(name = "ticket_id_fk"))
	public Ticket ticket;

	public long getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(Long passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getPassernger_first_name() {
		return passernger_first_name;
	}

	public void setPassernger_first_name(String passernger_first_name) {
		this.passernger_first_name = passernger_first_name;
	}

	public String getPassernger_last_name() {
		return passernger_last_name;
	}

	public void setPassernger_last_name(String passernger_last_name) {
		this.passernger_last_name = passernger_last_name;
	}

	public int getPassernger_age() {
		return passernger_age;
	}

	public void setPassernger_age(int passernger_age) {
		this.passernger_age = passernger_age;
	}

	public String getPassernger_gender() {
		return passernger_gender;
	}

	public void setPassernger_gender(String passernger_gender) {
		this.passernger_gender = passernger_gender;
	}

	public int getPassernger_seat_number() {
		return passernger_seat_number;
	}

	public void setPassernger_seat_number(int passernger_seat_number) {
		this.passernger_seat_number = passernger_seat_number;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Passenger() {
		super();
	}

	public Passenger(Long passenger_id, String passernger_first_name, String passernger_last_name, int passernger_age,
			String passernger_gender, int passernger_seat_number, Ticket ticket) {
		super();
		this.passenger_id = passenger_id;
		this.passernger_first_name = passernger_first_name;
		this.passernger_last_name = passernger_last_name;
		this.passernger_age = passernger_age;
		this.passernger_gender = passernger_gender;
		this.passernger_seat_number = passernger_seat_number;
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Passenger [passenger_id=" + passenger_id + ", passernger_first_name=" + passernger_first_name
				+ ", passernger_last_name=" + passernger_last_name + ", passernger_age=" + passernger_age
				+ ", passernger_gender=" + passernger_gender + ", passernger_seat_number=" + passernger_seat_number
				+ ", ticket=" + ticket + "]";
	}

}
