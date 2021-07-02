package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

	@OrderBy("endedDate DESC")
	List<JobExperience> findByResumeIdOrderByEndedDateDesc(int id);
	
}
