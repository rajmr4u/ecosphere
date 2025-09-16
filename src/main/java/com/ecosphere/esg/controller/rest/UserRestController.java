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
	
	private final PasswordEncoder encoder;

	private static final Logger logger = LogManager.getLogger(UserRestController.class);

	public UserRestController(UserRepository repository,PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}



	@PostMapping("/login")
	public List<User> getUsers(@RequestBody User user) {
        //  type = "rajesh@ecosphere.no";
		logger.debug("User Id ..." + user.getUserid());
		return (user.getUserid() == null) ? repository.findAll() : repository.findByUserid(user.getUserid());
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		logger.debug("User Details   : "+user);
		if (user==null) {
			throw new UserNotFoundException("Pass valid User Details ");
		}
			return repository.save(user);
	}
	
}
