package com.example.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.concretes.Technology;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeGetDto {

	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	
	private CandidateUser candidate;
	
	private String githubLink;
	
	private String linkedLink;
	
	private String photo;
	
	private String description;
	
	private LocalDateTime updatedDate;
	
	private List<JobExperience> jobExperiences;
	
	private List<Language> languages;
	
	private List<Technology> technologies;
	
	private List<Education> education;
	
}
