package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.Graduate;

public interface GraduateDao extends JpaRepository<Graduate, Integer> {
	
}
