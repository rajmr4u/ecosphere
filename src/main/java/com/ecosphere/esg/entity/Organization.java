package com.ecosphere.esg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int orgid;
	@Column(nullable = false)
	private String orgname;
	@Column(nullable = false)
	private int industry;
	@Column(nullable = true)
	private String orgnumber;
	@Column(nullable = true)
	private String billingtype;
	@Column(nullable = true)
	private String country;
	@Column(nullable = true)
	private String address;
	@Column(nullable = true)
	private String email;
	@Column(nullable = true)
	private String contactnumber;
	@Column(nullable = true)
	private String contactperson;
	
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactnumber() {
		return contactnumber;
	}


	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}


	public String getContactperson() {
		return contactperson;
	}


	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}


	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getOrgid() {
		return orgid;
	}


	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}


	public String getOrgname() {
		return orgname;
	}


	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}


	public int getIndustry() {
		return industry;
	}


	public void setIndustry(int industry) {
		this.industry = industry;
	}


	public String getOrgnumber() {
		return orgnumber;
	}


	public void setOrgnumber(String orgnumber) {
		this.orgnumber = orgnumber;
	}


	public String getBillingtype() {
		return billingtype;
	}


	public void setBillingtype(String billingtype) {
		this.billingtype = billingtype;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
	
	
}
