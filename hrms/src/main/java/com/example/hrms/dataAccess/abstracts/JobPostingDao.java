package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.JobPostingDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

//	@Query("Select new com.example.hrms.entities.dtos.JobPostingDto"
//			+ "(j.id, e.companyName, jp.position, j.quota, j.releaseDate, j.applicationDeadline) "
//			+ "From JobPosting j Inner Join j.employerUser e Inner Join j.jobPosition jp where j.isActive=true ")
//	List<JobPostingDto> findByIsActiveTrue();
//	
//	@Query("Select new com.example.hrms.entities.dtos.JobPostingDto"
//			+ "(j.id, e.companyName, jp.position, j.quota, j.releaseDate, j.applicationDeadline) "
//			+ "From JobPosting j Inner Join j.employerUser e Inner Join j.jobPosition jp where j.isActive=false ")
//	List<JobPostingDto> findByIsActiveFalse();
//	
	@Query("Select new com.example.hrms.entities.dtos.JobPostingDto" 
			+ "(j.id, e.companyName, jp.position, j.quota, j.releaseDate, j.applicationDeadline)"
			+ "From JobPosting j Inner Join j.employerUser e Inner Join j.jobPosition jp where e.companyName=:companyName And j.isActive=true")
	List<JobPostingDto> findByIsActiveAndEmployerUser_CompanyName(String companyName);
	
	@Query("Select new com.example.hrms.entities.dtos.JobPostingDto" 
			+ "(j.id, e.companyName, jp.position, j.quota, j.releaseDate, j.applicationDeadline)" 
			+ "From JobPosting j Inner Join j.employerUser e Inner Join j.jobPosition jp where j.isActive=true Order By j.applicationDeadline ASC")
	List<JobPostingDto> findByIsActiveOrderByApplicationDeadline();
	
	JobPosting getById(int id);
	
	List<JobPosting> findByIsActive(boolean status);
	
	List<JobPosting> getByIsActive(boolean status, Pageable pageable);
	
}
