package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	
}
