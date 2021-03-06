package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.EmployerUser;

public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer> {

	EmployerUser getByCompanyName(String companyName);
	
	boolean existsByCompanyName(String companyName);
	
}
