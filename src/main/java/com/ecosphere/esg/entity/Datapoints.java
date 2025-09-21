package com.ecosphere.esg.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Datapoints {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long datapointid;
	long reportid;
	long metricid;
	String value;
	String source;
	Date collectiondate;
	
	public Datapoints() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getDatapointid() {
		return datapointid;
	}

	public void setDatapointid(long datapointid) {
		this.datapointid = datapointid;
	}

	public long getReportid() {
		return reportid;
	}

	public void setReportid(long reportid) {
		this.reportid = reportid;
	}

	public long getMetricid() {
		return metricid;
	}

	public void setMetricid(long metricid) {
		this.metricid = metricid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getCollectiondate() {
		return collectiondate;
	}

	public void setCollectiondate(Date collectiondate) {
		this.collectiondate = collectiondate;
	}

	

	
	
}
