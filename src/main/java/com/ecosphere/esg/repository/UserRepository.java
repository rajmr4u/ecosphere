package com.ecosphere.esg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserid(String username);
	List<User> findByOrgid(int orgid);
	
}
