package com.ecosphere.esg.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Frameworks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int standardid;
	String standardname;
	String regulatoryurl;
	Date lastupdated;
	
	public Frameworks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStandardid() {
		return standardid;
	}
	public void setStandardid(int standardid) {
		this.standardid = standardid;
	}
	public String getStandardname() {
		return standardname;
	}
	public void setStandardname(String standardname) {
		this.standardname = standardname;
	}
	public String getRegulatoryurl() {
		return regulatoryurl;
	}
	public void setRegulatoryurl(String regulatoryurl) {
		this.regulatoryurl = regulatoryurl;
	}
	public Date getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	
	

}
