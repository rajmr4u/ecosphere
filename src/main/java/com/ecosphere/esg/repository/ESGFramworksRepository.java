package com.ecosphere.esg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.Frameworks;

public interface ESGFramworksRepository extends JpaRepository<Frameworks, Integer> {
	Frameworks findByStandardid(int standardid);
}
