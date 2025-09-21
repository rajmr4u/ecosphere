package com.ecosphere.esg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.Metrics;

public interface ESGMetricsRepository extends JpaRepository<Metrics, Integer>{
	List<Metrics> findByStandardid(int standardId);
}
