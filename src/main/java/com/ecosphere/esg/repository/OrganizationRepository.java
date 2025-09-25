package com.ecosphere.esg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecosphere.esg.entity.Organization;


public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
	Organization findByOrgid(int orgid);
}
