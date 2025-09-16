package com.ecosphere.esg.controller.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.Organization;
import com.ecosphere.esg.exceptions.UserNotFoundException;
import com.ecosphere.esg.repository.OrganizationRepository;

@RestController
public class OrgRestController {
	

	@Autowired
	private final OrganizationRepository orgrepository;
	
	private static final Logger logger = LogManager.getLogger(OrgRestController.class);

	public OrgRestController(OrganizationRepository orgrepository) {
		this.orgrepository= orgrepository;
	}

	@GetMapping("/org1")
	public List<Organization> getOrganizations() {
		logger.debug("Org Details in getOrganizations1111  : ");
		return  orgrepository.findAll() ;
		
	}
	
	@PostMapping("/org")
	public List<Organization> getOrganizations(@RequestBody Organization org) {
		logger.debug("Org Details in getOrganizations  : "+org);
		return (org == null) ? orgrepository.findAll() : orgrepository.findByOrgid(org.getOrgid());
		
	}
	
	@PostMapping("/addorg")
	public Organization createUser(@RequestBody Organization org) {
		logger.debug("Org Details   : "+org);
		if (org==null) {
			throw new UserNotFoundException("Pass valid Organization  Details ");
		}
			return orgrepository.save(org);
	}

}
