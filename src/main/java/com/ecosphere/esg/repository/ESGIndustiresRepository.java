package com.ecosphere.esg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.Industries;

public interface ESGIndustiresRepository extends JpaRepository<Industries, Integer>{
	List<Industries> findByIndustryid(int id);
}
