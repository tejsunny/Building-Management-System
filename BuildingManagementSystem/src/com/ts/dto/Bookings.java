package com.ts.dto;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bookings {
	@Id@GeneratedValue
	private int bookingId;
	@ManyToOne
	@JoinColumn(name="FLAT_NO")	
	private Rooms rooms;
	@ManyToOne
	@JoinColumn(name="FACILITY_ID")	
	private Facilities facilities;
	
	@Column(length=25)
	private int noOfRegistrations;
	
    private java.sql.Date dateOfRegistration;
 
	
	public Bookings(int bookingId, Rooms rooms, Facilities facilities, int noOfRegistrations) {
		super();
		this.bookingId = bookingId;
		this.rooms = rooms;
		this.facilities = facilities;
		this.noOfRegistrations = noOfRegistrations;
	}
	public Bookings() {
	}
	
	public Bookings(Facilities facilities, Rooms rooms, int noOfRegistrations, java.sql.Date dateOfRegistration) {
		this.rooms = rooms;
		this.facilities = facilities;
		this.noOfRegistrations = noOfRegistrations;
		this.dateOfRegistration = dateOfRegistration;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Rooms getRooms() {
		return rooms;
	}
	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}
	public Facilities getFacilities() {
		return facilities;
	}
	public void setFacilities(Facilities facilities) {
		this.facilities = facilities;
	}
	public int getNoOfRegistrations() {
		return noOfRegistrations;
	}
	public void setNoOfRegistrations(int noOfRegistrations) {
		this.noOfRegistrations = noOfRegistrations;
	}
	public java.sql.Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(java.sql.Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
}
