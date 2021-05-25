package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.CandidateUser;

public interface CandidateUserDao extends JpaRepository<CandidateUser, Integer> {
	

}
