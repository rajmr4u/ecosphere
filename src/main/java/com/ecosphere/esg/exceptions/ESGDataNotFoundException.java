package com.ecosphere.esg.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ESGDataNotFoundException extends RuntimeException {
	
	private static final Logger logger = LogManager.getLogger(ESGDataNotFoundException.class);
	
	public ESGDataNotFoundException(String errorMessage) {
		super(errorMessage);
		logger.error(errorMessage);
	    
	  }

}
