package com.ts.dto;
import java.util.ArrayList;






import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Tenants {
	@Id@GeneratedValue
	private int tenantId;
	@Column(length=25)
	private String tenantName;
	@Column(length=25)
	private String tenantPhNumber;
	@Column(length=25)
	private String tenantPassword;
	public Tenants() {
		
	}
	public Tenants(int tenantId, String tenantName, String tenantPhNumber, String tenantPassword) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.tenantPhNumber = tenantPhNumber;
		this.tenantPassword = tenantPassword;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getTenantPhNumber() {
		return tenantPhNumber;
	}
	public void setTenantPhNumber(String tenantPhNumber) {
		this.tenantPhNumber = tenantPhNumber;
	}
	public String getTenantPassword() {
		return tenantPassword;
	}
	public void setTenantPassword(String tenantPassword) {
		this.tenantPassword = tenantPassword;
	}
	
}

