package com.ecosphere.esg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Industries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int industryid;
	@Column(nullable = false)
	String industryname;
	String description;
	
	
	
	public Industries() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIndustryid() {
		return industryid;
	}
	public void setIndustryid(int industryid) {
		this.industryid = industryid;
	}
	public String getIndustryname() {
		return industryname;
	}
	public void setIndustryname(String industryname) {
		this.industryname = industryname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
