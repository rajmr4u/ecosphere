package com.ecosphere.esg.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Metrics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long metricid;
	@Column(nullable = false)
	int standardid;
	@Column(nullable = false)
	String metricname;
	String metrictype;
	String unit;
	String source;
	@Column(nullable = false)
	Date validfrom;
	Date validtil;
	String description;
	
	public Metrics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getMetricid() {
		return metricid;
	}
	public void setMetricid(long metricid) {
		this.metricid = metricid;
	}
	public int getStandardId() {
		return standardid;
	}
	public void setStandardId(int standardId) {
		this.standardid = standardId;
	}
	public String getMetricname() {
		return metricname;
	}
	public void setMetricname(String metricname) {
		this.metricname = metricname;
	}
	public String getMetrictype() {
		return metrictype;
	}
	public void setMetrictype(String metrictype) {
		this.metrictype = metrictype;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getValidFrom() {
		return validfrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validfrom = validFrom;
	}
	public Date getValidtil() {
		return validtil;
	}
	public void setValidtil(Date validtil) {
		this.validtil = validtil;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
