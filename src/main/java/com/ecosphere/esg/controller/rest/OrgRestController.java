package com.ecosphere.esg.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.Organization;
import com.ecosphere.esg.repository.OrganizationRepository;

@RestController
public class OrgRestController {
	

	@Autowired
	private final OrganizationRepository orgrepository;

	public OrgRestController(OrganizationRepository orgrepository) {
		this.orgrepository= orgrepository;
	}


	@GetMapping("/org")
	public List<Organization> getOrganizations() {
        //  type = "rajesh@ecosphere.no";
		System.out.print("Organization    Details   : ");
		//return (org == null) ? repository.findAll() : repository.findAllById(1);
		return  orgrepository.findAll();
	}

}
