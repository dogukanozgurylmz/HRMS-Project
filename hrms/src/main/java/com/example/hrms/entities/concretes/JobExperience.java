package com.example.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_job_exp")
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@Column(name = "company_name")
	private String companyName;
	
	@ManyToOne(targetEntity = JobPosition.class)
	@JoinColumn(name = "job_position_id", referencedColumnName = "id")
	private JobPosition jobPosition;
	
	@Column(name = "started_date")
	private LocalDate startedDate;
	
	@Column(name = "ended_date")
	private LocalDate endedDate;
	
	@JsonIgnore
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
}
