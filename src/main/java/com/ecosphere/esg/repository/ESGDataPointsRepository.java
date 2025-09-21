package com.ecosphere.esg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.Datapoints;

public interface ESGDataPointsRepository extends JpaRepository<Datapoints, Integer>{
	List<Datapoints> findByReportid(long reportid);
}
