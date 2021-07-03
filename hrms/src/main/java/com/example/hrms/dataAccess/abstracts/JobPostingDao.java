package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingDto;
import com.example.hrms.entities.dtos.JobPostingFilter;

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
	 
	@Query("Select j from com.example.hrms.entities.concretes.JobPosting j where"
            + " ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
            +" and ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
            +" and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
            +" and ((:#{#filter.workingTimeId}) IS NULL OR j.workingTime.id IN (:#{#filter.workingTimeId}))"
            +" and j.isActive=true")
    Page<JobPosting> getByFilter(@Param("filter")JobPostingFilter jobPostingFilter, Pageable pageable);
	
}
