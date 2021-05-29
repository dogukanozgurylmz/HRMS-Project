package com.example.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_postings")
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private EmployerUser employerUser;

	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private int jobPositionId;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private int cityId;

	@Column(name = "job_detail")
	private String jobDetail;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;

	@Column(name = "quota")
	private int quota;

	@Column(name = "release_date")
	private LocalDateTime releaseDate;

	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;

	@Column(name = "is_active")
	private boolean isActive;

}
