package com.ts.dto;
//import java.util.ArrayList;



import java.util.ArrayList;


import java.util.List;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
@Entity
public class Landlords {
	@Id@GeneratedValue
	private int landlordId;
	@Column(length=25)
	private String landlordName;
	@Column(length=25)
	private String landlordPhNumber;
	@Column(length=25)
	private String landlordPassword;
	public Landlords() {
		
	}
	public Landlords(int landlordId, String landlordName, String landlordPhNumber, String landlordPassword) {
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordPhNumber = landlordPhNumber;
		this.landlordPassword = landlordPassword;
	}


	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	public String getLandlordPhNumber() {
		return landlordPhNumber;
	}

	public void setLandlordPhNumber(String landlordPhNumber) {
		this.landlordPhNumber = landlordPhNumber;
	}

	public String getLandlordPassword() {
		return landlordPassword;
	}

	public void setLandlordPassword(String landlordPassword) {
		this.landlordPassword = landlordPassword;
	}		
}
