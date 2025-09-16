package com.ecosphere.esg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class EcosphereApplication {

	private static final Logger logger = LogManager.getLogger(EcosphereApplication.class);
	
	public static void main(String[] args) {
		logger.info("EcosphereApplication Started  : ");
		SpringApplication.run(EcosphereApplication.class, args);
	}

}
