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
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	public long ticket_id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable =false,foreignKey = @ForeignKey(name = "user_id_fk"))
	public UserProfile userProfile;

	@ManyToOne
	@JoinColumn(name = "flight_details_id", nullable =false,foreignKey = @ForeignKey(name = "flight_details_id_fk"))
	public FlightDetails flightDetails;

	@Column(name = "ticket_status")
	public String ticket_status;

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	public String getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}

	public Ticket() {
		super();
	}

	public Ticket(long ticket_id, UserProfile userProfile, FlightDetails flightDetails, String ticket_status) {
		super();
		this.ticket_id = ticket_id;
		this.userProfile = userProfile;
		this.flightDetails = flightDetails;
		this.ticket_status = ticket_status;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", userProfile=" + userProfile + ", flightDetails=" + flightDetails
				+ ", ticket_status=" + ticket_status + "]";
	}

}
