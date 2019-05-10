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
import javax.persistence.OneToOne;
@Entity
public class Rooms {
	
	@Id
	private int flatNo;
	
	@Column(length=25)
	private String flatType;
	
	@Column(length=25)
	private int floor;
	
	@Column(length=25)
	private String vacancy;
	
	
	@Column(length=25)
	private String landlordvacancy;
	
	
	public Rooms(int flatNo, String flatType, int floor, String vacancy, String landlordvacancy, float flatRate,
			Landlords landlords, Tenants tenants, List<Bills> bills) {
		super();
		this.flatNo = flatNo;
		this.flatType = flatType;
		this.floor = floor;
		this.vacancy = vacancy;
		this.landlordvacancy = landlordvacancy;
		this.flatRate = flatRate;
		this.landlords = landlords;
		this.tenants = tenants;
		this.bills = bills;
	}
	public String getLandlordvacancy() {
		return landlordvacancy;
	}
	public void setLandlordvacancy(String landlordvacancy) {
		this.landlordvacancy = landlordvacancy;
	}

	@Column(length=25)
	private float flatRate;
	@ManyToOne
	@JoinColumn(name="LANDLORD_ID")	
	private Landlords landlords;
	
	@ManyToOne
	@JoinColumn(name="TENANT_ID")
	private Tenants tenants;
	
	@OneToMany(mappedBy="rooms")	
	private List<Bills> bills =new ArrayList<Bills>();
	
	
	public Rooms() {
		
	}
	public Rooms(int flatNo, String flatType, int floor, String vacancy,float flatRate) {
		super();
		this.flatNo = flatNo;
		this.flatType = flatType;
		this.floor = floor;
		this.vacancy = vacancy;
		this.flatRate = flatRate;
	}
	
	public Rooms(int flatNo, String flatType, int floor, String vacancy,float flatRate, Landlords landlords,
			Tenants tenants) {
		super();
		this.flatNo = flatNo;
		this.flatType = flatType;
		this.floor = floor;
		this.vacancy = vacancy;
		this.landlords = landlords;
		this.flatRate = flatRate;
		this.tenants = tenants;
	}
	
	public List<Bills> getBills() {
		return bills;
	}
	public void setBills(List<Bills> bills) {
		this.bills = bills;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setRoomType(String flatType) {
		this.flatType = flatType;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getVacancy() {
		return vacancy;
	}
	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}
	public float getFlatRate() {
		return flatRate;
	}
	public void setFlatRate(float flatRate) {
		this.flatRate = flatRate;
	}

	public Landlords getLandlords() {
		return landlords;
	}

	public void setLandlords(Landlords landlords) {
		this.landlords = landlords;
	}
	public Tenants getTenants() {
		return tenants;
	}

	public void setTenants(Tenants tenants) {
		this.tenants = tenants;
	}


}
