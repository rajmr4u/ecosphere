package com.ecosphere.esg.controller.rest;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.Organization;
import com.ecosphere.esg.exceptions.RecordNotFoundException;
import com.ecosphere.esg.repository.OrganizationRepository;

@RestController
public class OrgRestController {

	@Autowired
	private final OrganizationRepository orgrepository;

	private static final Logger logger = LogManager.getLogger(OrgRestController.class);

	public OrgRestController(OrganizationRepository orgrepository) {
		this.orgrepository = orgrepository;
	}

	@GetMapping("/api/getorg")
	public Organization getOrganizations(@RequestParam Integer orgId) {
		logger.debug("Org Details in getOrganizations  :-{} " + orgId);
		return Optional.ofNullable(orgrepository.findByOrgid(orgId))
		    	.orElseThrow(() -> new RecordNotFoundException("No Organization found for orgId: " + orgId));
	
	}

	@PostMapping("/api/addorg")
	public Organization createOrg(@RequestBody Organization org) {
		logger.debug("Org Details   : " + org);
		if (org == null) {
			throw new RecordNotFoundException("Pass valid Organization  Details ");
		}
		return orgrepository.save(org);
	}

	@PostMapping("/api/updateorg")
	public Organization updateOrg(@RequestBody Organization organization) {
		logger.debug("Org Details   : " + organization);
		if (organization == null) {
		    throw new RecordNotFoundException("Pass valid Organization Details");
		}

		Organization org = Optional.ofNullable(orgrepository.findByOrgid(organization.getOrgid()))
		        .orElseThrow(() -> new RecordNotFoundException("Organization not found with id: " + organization.getOrgid()));

		org.setAddress(organization.getAddress());
		org.setContactnumber(organization.getContactnumber());
		org.setContactperson(organization.getContactperson());
		org.setBillingtype(organization.getBillingtype());
		org.setEmail(organization.getEmail());
		return orgrepository.save(org);
	}
}
