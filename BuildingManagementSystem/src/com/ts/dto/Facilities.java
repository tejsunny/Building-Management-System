package com.ts.dto;
import java.util.ArrayList;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Facilities {
	
	@Id@GeneratedValue
	private int facilityId;
	@Column(length=25)
	private String facilityName;
	@Column(length=25)
	private int limitedPeople;
	public int getFacilityId() {
		return facilityId;
	}
	public Facilities() {
	}
	public Facilities(int facilityId, String facilityName, int limitedPeople) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.limitedPeople = limitedPeople;
	}	public String getFacilityName() {
		return facilityName;
	}
	
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public int getLimitedPeople() {
		return limitedPeople;
	}
	public void setLimitedPeople(int limitedPeople) {
		this.limitedPeople = limitedPeople;
	}
	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}
	}
