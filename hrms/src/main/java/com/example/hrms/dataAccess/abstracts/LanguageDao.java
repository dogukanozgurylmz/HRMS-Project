package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

	List<Language> findByResumeId(int id);
	
}
