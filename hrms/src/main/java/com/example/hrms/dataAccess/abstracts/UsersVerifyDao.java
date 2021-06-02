package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.UsersVerify;

public interface UsersVerifyDao extends JpaRepository<UsersVerify, Integer> {

	UsersVerify getByVerifyCode(String verifyCode);
	
	boolean existsByVerifyCode(String verifyCode);
	
}
