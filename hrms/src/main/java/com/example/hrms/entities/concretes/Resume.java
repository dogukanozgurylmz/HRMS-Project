package com.example.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = CandidateUser.class)
	@JoinColumn(name = "candidate_id")
	private CandidateUser candidateUser;
	
	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "linked_link")
	private String linkedLink;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "is_active")
	private boolean isActive;

	
	@OneToMany(mappedBy = "resume" ) 
	private List<Language> languages;
	  
	@OneToMany(mappedBy = "resume" ) 
	private List<Technology> technologies;
	  
	@OneToMany(mappedBy = "resume" ) 
	private List<Education> education;
	 
	@OneToMany(mappedBy = "resume" ) 
	private List<JobExperience> jobExperiences;
	
}
