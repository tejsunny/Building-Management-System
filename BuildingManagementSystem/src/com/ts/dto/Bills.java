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
public class Bills {
	@Id@GeneratedValue
	private int billId;
	@ManyToOne
	@JoinColumn(name="FLAT_NO")
	private Rooms rooms;
	@Column(length=25)
	private float waterBill;
	@Column(length=25)
	private float electricityBill;
	@Column(length=25)
	private float maintenanceBill;
	public Bills() {
		
	}
	
	

	public Bills(int billId, Rooms rooms, float waterBill, float electricityBill, float maintenanceBill) {
		super();
		this.billId = billId;
		this.rooms = rooms;
		this.waterBill = waterBill;
		this.electricityBill = electricityBill;
		this.maintenanceBill = maintenanceBill;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public float getWaterBill() {
		return waterBill;
	}

	public void setWaterBill(float waterBill) {
		this.waterBill = waterBill;
	}

	public float getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(float electricityBill) {
		this.electricityBill = electricityBill;
	}

	public float getMaintenanceBill() {
		return maintenanceBill;
	}

	public void setMaintenanceBill(float maintenanceBill) {
		this.maintenanceBill = maintenanceBill;
	}
	
	
}
