package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeGetDto;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

	List<Resume> findAllByCandidateUserId(int candidateUserId);
	
}
