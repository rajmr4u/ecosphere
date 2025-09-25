package com.ecosphere.esg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.Industrymetrics;

public interface ESGIndustryMetricsRepository extends JpaRepository<Industrymetrics, Integer>{
	List<Industrymetrics> findByIndustryid(int industryid);

}
