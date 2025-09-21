package com.ecosphere.esg.controller.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.Datapoints;
import com.ecosphere.esg.entity.Metrics;
import com.ecosphere.esg.repository.ESGDataPointsRepository;
import com.ecosphere.esg.repository.ESGMetricsRepository;

@RestController
public class ESGRestController {

	private static final Logger logger = LogManager.getLogger(ESGRestController.class);
	
	@Autowired
	private final ESGDataPointsRepository repository;
	@Autowired
	private final ESGMetricsRepository metricsrepo;
	
	public ESGRestController(ESGDataPointsRepository repository,ESGMetricsRepository metricsrepo) {
		this.repository = repository;
		this.metricsrepo = metricsrepo;
	}
	
	@GetMapping("/api/getdatapoints/{reportid}")
	public List<Datapoints> getDataElements(@PathVariable long reportid) {
		logger.debug("get Data Elements reportId: "+ reportid);
		return  repository.findByReportid(reportid) ;
		
	}
	
	@GetMapping("/api/getmetrics/{standardId}")
	public List<Metrics> getMetrics(@PathVariable int standardId) {
		logger.debug("get getMetrics standardId: "+standardId);
		
		return  metricsrepo.findByStandardid(standardId);
	}
	
	
}
