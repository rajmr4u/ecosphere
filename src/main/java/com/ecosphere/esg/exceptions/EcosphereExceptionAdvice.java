package com.ecosphere.esg.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EcosphereExceptionAdvice {
	
	@ExceptionHandler(RecordNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(RecordNotFoundException ex) {
	    return ex.getMessage();
	  }

	@ExceptionHandler(ESGDataNotFoundException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  String esgDataNotFoundHandler(ESGDataNotFoundException ex) {
	    return ex.getMessage();
	  }
//	  @ExceptionHandler(ESGDataNotFoundException.class)
//	    public ResponseEntity<Object> handleException(Exception ex) {
//	        Map<String, Object> body = new HashMap<>();
//	        body.put("timestamp", LocalDateTime.now());
//	        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//	        body.put("error", "Internal Server Error");
//	        body.put("message", ex.getMessage());
//	        
//	        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
	
}
