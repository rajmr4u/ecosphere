package com.ecosphere.esg.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
//import com.ecosphere.esg.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecosphere.esg.entity.User;
import com.ecosphere.esg.exceptions.UserNotFoundException;
import com.ecosphere.esg.repository.UserRepository;

@Service
public class EcoUserDetailsService implements UserDetailsService {
	@Autowired
	private final UserRepository repo;

	private static final Logger logger = LogManager.getLogger(EcoUserDetailsService.class);

	public EcoUserDetailsService(UserRepository repository) {
		super();
		this.repo = repository;
	}
	
	   @Override
	    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
		   logger.debug("In EcoUserDetailService"+username);
		   
		   User user = repo.findByUserid(username);
		   if (user== null) {
		        throw new UsernameNotFoundException("User not found: " + username);
		    }

		    
		    logger.debug("User Informaniton : "+user.getPassword());
		    return org.springframework.security.core.userdetails.User.builder()
		            .username(user.getUserid())
		            .password(user.getPassword())
		            .build();
		   /*
	        return  repo.findByUserid(username).map(user -> org.springframework.security.core.userdetails.User.builder()
	                        .username(user.getUsername())
	                        .password(user.getPassword())
	                        .disabled(!user.isEnabled())
	                        .authorities(user.getRoles().toArray(new String[0]))
	                        .build())
	                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
	                */
	    }
}

	
