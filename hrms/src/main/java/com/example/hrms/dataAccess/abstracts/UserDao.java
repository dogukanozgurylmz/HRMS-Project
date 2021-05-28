package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User getByEmailAddress(String emailAddress);
	
}
