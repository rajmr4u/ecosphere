package com.ecosphere.esg.controller.rest;




import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.User;
import com.ecosphere.esg.exceptions.UserNotFoundException;
import com.ecosphere.esg.repository.UserRepository;



@RestController
public class UserRestController {

	@Autowired
	private final UserRepository repository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;


	private static final Logger logger = LogManager.getLogger(UserRestController.class);

	public UserRestController(UserRepository repository) {
		this.repository = repository;
	}


	@PostMapping("/api/users")
	public List<User> getUsers(@RequestBody User user) {
    	logger.debug("User Id ..." + user.getUserid());
		return  repository.findAll();
	}
	
	@PostMapping("/api/auth")
	public User getUser(@RequestBody User user) {
        
		logger.debug("In Get User /api/auth..." + user.getUserid());
		User us = null;
		if(user!=null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			logger.debug("In Get User /api/auth... Encripted Password" + user.getPassword());
			//return repository.findByUseridAndPassword(user.getUserid(),user.getPassword());
			us = repository.findByUseridAndPassword(user.getUserid(),user.getPassword());
		}
		
		else
			throw new UserNotFoundException("Pass valid User Details ");	
		
		logger.debug("In Get User /api/auth... User Object before return" + user.getUserid() +"------" + user.getPassword() + "------" +user.getRole()+ "------" +user.getId());
		return us;
		
	}
	
	
	@PostMapping("/api/updatepassword")
	public User updatePassword(@RequestBody User user) {
        
		logger.debug("In updatePassword..." + user.getUserid());
		if (user.getUserid()==null) {
			throw new UserNotFoundException("Pass valid User Details ");
		}
		    User usr = repository.findByUserid(user.getUserid());
		    usr.setPassword(passwordEncoder.encode(user.getPassword()));
			return repository.save(usr);
		
	}
	
	
	@PostMapping("/api/createuser")
	public User createUser(@RequestBody User user) {
		logger.debug("User Details   : "+user);
		if (user==null) {
			throw new UserNotFoundException("Pass valid User Details ");
		}
		    user.setPassword(passwordEncoder.encode(user.getPassword()));
			return repository.save(user);
	}
	
}
