package com.ecosphere.esg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosphere.esg.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserid(String username);
	User findByUseridAndPassword(String username, String password);
}
