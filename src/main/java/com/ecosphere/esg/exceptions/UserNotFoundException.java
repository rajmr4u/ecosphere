package com.ecosphere.esg.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class UserNotFoundException extends RuntimeException {
	
	private static final Logger logger = LogManager.getLogger(UserNotFoundException.class);
	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
		logger.error(errorMessage);
	    
	  }

}
