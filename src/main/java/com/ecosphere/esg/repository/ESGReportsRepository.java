package com.ecosphere.esg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.Reports;

public interface ESGReportsRepository extends JpaRepository<Reports, Long>{
	
	List<Reports> findByOrgid(int orgid);

}
