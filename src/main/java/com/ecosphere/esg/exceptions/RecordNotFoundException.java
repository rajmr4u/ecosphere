package com.ecosphere.esg.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class RecordNotFoundException extends RuntimeException {
	
	private static final Logger logger = LogManager.getLogger(RecordNotFoundException.class);
	public RecordNotFoundException(String errorMessage) {
		super(errorMessage);
		logger.error(errorMessage);
	    
	  }

}
