package com.example.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitilazier", "handler" })
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "linked_link")
	private String linkedLink;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;

	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne(targetEntity = CandidateUser.class)
	@JoinColumn(name = "candidate_id")
	private CandidateUser candidateUser;
	
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	private List<Language> languages;
	  
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	private List<Technology> technologies;
	  
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	private List<Education> education;
	 
	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	private List<JobExperience> jobExperiences;
	
}
