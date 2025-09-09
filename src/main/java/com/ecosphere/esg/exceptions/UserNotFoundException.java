package com.ecosphere.esg.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String errorMessage) {
		
	    super(errorMessage);
	  }

}
