package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrms.entities.concretes.CandidateUser;

@Repository
public interface CandidateUserDao extends JpaRepository<CandidateUser, Integer> {

	CandidateUser getByNationalityIdentity(String nationalityIdentity);
	
}
