package com.ecosphere.esg.controller.rest;




import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.User;
import com.ecosphere.esg.exceptions.RecordNotFoundException;
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


	@GetMapping("/api/getusers/{orgid}")
	public List<User> getUsers(@PathVariable int orgid) {
    	logger.debug("getUsers Orgid ..{} " + orgid);
    	return Optional.ofNullable(repository.findByOrgid(orgid))
    	        .orElseThrow(() -> new RecordNotFoundException("No users found for orgId: " + orgid));
		
	}
	
	@PostMapping("/api/auth")
	public User getUser(@RequestBody User user){
        
		logger.debug("In Get User /api/auth..." + user.getUserid());
		User us = Optional.ofNullable(user)
		        .map(u -> repository.findByUserid(u.getUserid()))
		        .orElseThrow(() -> new RecordNotFoundException("Pass valid User Credentials"));

		logger.debug("In Get User /api/auth... us  :- {}", us);

		if (!authenticateUser(user.getPassword(), us.getPassword())) {
		    throw new RecordNotFoundException("Pass valid User Credentials");
		}
		return us;
		
	}
	
	
	public boolean authenticateUser(String rawPassword, String storedEncodedPassword) {
		logger.debug("In authenticateUser...   {}" + passwordEncoder.matches(rawPassword, storedEncodedPassword));
        return passwordEncoder.matches(rawPassword, storedEncodedPassword);
    }
	
	@PostMapping("/api/updatepassword")
	public User updatePassword(@RequestBody User user) {
        
		logger.debug("In /api/updatepassword... :- {} "+user);
		
		User usr = Optional.ofNullable(user)
				.map(u -> repository.findByUserid(u.getUserid()))
		        .orElseThrow(() -> new RecordNotFoundException("Pass valid User Credentials"));

		    usr.setPassword(passwordEncoder.encode(user.getPassword()));
			return repository.save(usr);
		
	}
	
	
	@PostMapping("/api/updateuser")
	public User updateUser(@RequestBody User user) {
        
		if (user == null || user.getUserid()==null) {
			throw new RecordNotFoundException("Pass valid User Details ");
		}


		logger.debug("In /api/updateuser... {}", user.getUserid());
		
		User usr = Optional.ofNullable(repository.findByUserid(user.getUserid()))
				   .map(existing -> {
			            existing.setAddress(user.getAddress());
			            existing.setRole(user.getRole());
			            existing.setContactnumber(user.getContactnumber());
			            return existing;
			        })
		        .orElseThrow(() -> new RecordNotFoundException("User not found with id: " + user.getUserid()));
		  return repository.save(usr);
		
	}
	
	@PostMapping("/api/createuser")
	public User createUser(@RequestBody User user) {
		logger.debug("User Details   : {} "+user);
		if (user==null) {
			throw new RecordNotFoundException("Pass valid User Details ");
		}
		    user.setPassword(passwordEncoder.encode(user.getPassword()));
			return repository.save(user);
	}
	
}
