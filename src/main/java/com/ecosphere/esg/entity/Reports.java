package com.ecosphere.esg.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reports {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long reportid;
	@Column(nullable = false)
	int orgid;
	@Column(nullable = false)
	int standardid;
	Date startdate;
	Date enddate;
	int reportyear;
	Date submissiondate;
	String status;
	
	public Reports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getReportid() {
		return reportid;
	}

	public void setReportid(long reportid) {
		this.reportid = reportid;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public int getStandardid() {
		return standardid;
	}

	public void setStandardid(int standardid) {
		this.standardid = standardid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getReportyear() {
		return reportyear;
	}

	public void setReportyear(int reportyear) {
		this.reportyear = reportyear;
	}

	public Date getSubmissiondate() {
		return submissiondate;
	}

	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
