package com.ecosphere.esg.controller.rest;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.Datapoints;
import com.ecosphere.esg.entity.Industries;
import com.ecosphere.esg.entity.Industrymetrics;
import com.ecosphere.esg.entity.Metrics;
import com.ecosphere.esg.entity.Reports;
import com.ecosphere.esg.exceptions.ESGDataNotFoundException;
import com.ecosphere.esg.exceptions.RecordNotFoundException;
import com.ecosphere.esg.repository.ESGDataPointsRepository;
import com.ecosphere.esg.repository.ESGFramworksRepository;
import com.ecosphere.esg.repository.ESGIndustiresRepository;
import com.ecosphere.esg.repository.ESGIndustryMetricsRepository;
import com.ecosphere.esg.repository.ESGMetricsRepository;
import com.ecosphere.esg.repository.ESGReportsRepository;

@RestController
public class ESGRestController {

	private static final Logger logger = LogManager.getLogger(ESGRestController.class);
	
	@Autowired
	private final ESGDataPointsRepository repository;
	@Autowired
	private final ESGMetricsRepository metricsrepo;
	@Autowired
	private final ESGIndustiresRepository industryrepo;
	@Autowired
	private final ESGReportsRepository reportsrepo;
	@Autowired
	private final ESGFramworksRepository framworkrepo;
	@Autowired
	private final ESGIndustryMetricsRepository industrymerticsrepo;
	
	
	

	public ESGRestController(ESGDataPointsRepository repository, ESGMetricsRepository metricsrepo,
			ESGIndustiresRepository industryrepo, ESGReportsRepository reportsrepo, ESGFramworksRepository framworkrepo,
			ESGIndustryMetricsRepository industrymerticsrepo) {
		super();
		this.repository = repository;
		this.metricsrepo = metricsrepo;
		this.industryrepo = industryrepo;
		this.reportsrepo = reportsrepo;
		this.framworkrepo = framworkrepo;
		this.industrymerticsrepo = industrymerticsrepo;
	}
	

	@GetMapping("/api/getdatapoints/{reportid}")
	public List<Datapoints> getDataElements(@PathVariable long reportid) {
		logger.debug("get Data Elements reportId: {}"+ reportid);
		return Optional.ofNullable(repository.findByReportid(reportid))
		.orElseThrow(()-> new RecordNotFoundException("Report is not found with reportId: " + reportid));
				
	}
	
	@GetMapping("/api/getmetrics/{standardId}")
	public List<Metrics> getMetrics(@PathVariable int standardId) {
		logger.debug("get getMetrics standardId: "+standardId);
		
		return Optional.ofNullable(metricsrepo.findByStandardid(standardId))
				.orElseThrow(()-> new RecordNotFoundException("StandardId is not found for  StandardId : " + standardId));
	}
	
	@GetMapping("/api/getindustry")
	public List<Industries> getIndustry(@RequestParam(required = false) Integer industryId) {
		logger.debug("getIndustry industryId: {}", industryId);

	    List<Industries> industries = (industryId != null) 
	            ? industryrepo.findByIndustryid(industryId) 
	            : industryrepo.findAll();
	    if (industries == null || industries.isEmpty()) {
	        throw new RecordNotFoundException(
	                (industryId != null) 
	                        ? "No industry found with id: " + industryId 
	                        : "No industries found"
	        );
	    }

	    return industries;
	}
	
	@GetMapping("/api/getindustrymetrics")
	public List<Industrymetrics> getIndustryMetrics(@RequestParam(required = false) Integer industryId) {
		logger.debug("Fetching industry metrics for industryId: {}", industryId);
		if (industryId == null) {
		    throw new ESGDataNotFoundException("Pass valid industry details");
		}

		return Optional.ofNullable(industrymerticsrepo.findByIndustryid(industryId))
		        .orElseThrow(() -> new RecordNotFoundException("No metrics found for industryId: " + industryId));

	}
	
	@GetMapping("/api/getreport/{orgid}")
	public List<Reports> getReport(@PathVariable int orgid) {
		logger.debug("getIndustryMetrics getReport with Orgid: {}", orgid);

	    List<Reports> reports = (orgid != 0) 
	            ? reportsrepo.findByOrgid(orgid) 
	            : reportsrepo.findAll();

	    if (reports == null || reports.isEmpty()) {
	        throw new RecordNotFoundException(
	                (orgid != 0) 
	                        ? "No reports found for OrgId: " + orgid 
	                        : "No reports found"
	        );
	    }

	    return reports;
	}
	
}
