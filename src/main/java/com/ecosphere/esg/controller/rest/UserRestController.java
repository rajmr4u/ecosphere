package com.ecosphere.esg.controller.rest;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecosphere.esg.entity.User;
import com.ecosphere.esg.exceptions.UserNotFoundException;
import com.ecosphere.esg.repository.OrganizationRepository;
import com.ecosphere.esg.repository.UserRepository;



@RestController
public class UserRestController {

	@Autowired
	private final UserRepository repository;


	public UserRestController(UserRepository repository,OrganizationRepository orgrepository) {
		this.repository = repository;
	}



	@PostMapping("/login")
	public List<User> getUsers(@RequestBody User user) {
        //  type = "rajesh@ecosphere.no";
		System.out.print("User Id ..." + user.getUserid());
		return (user.getUserid() == null) ? repository.findAll() : repository.findByUserid(user.getUserid());
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		System.out.print("User Details   : "+user);
		if (user==null) {
			throw new UserNotFoundException("Pass valid User Details ");
		}
			return repository.save(user);
	}
	
}
