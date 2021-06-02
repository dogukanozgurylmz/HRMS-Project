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
import javax.validation.constraints.NotBlank;

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

	@NotBlank(message = "İş pozisyonu alanı boş bırakılamaz!")
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@NotBlank(message = "Şehir alanı boş bırakılamaz!")
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@NotBlank(message = "İş tanımı alanı boş bırakılamaz!")
	@Column(name = "description")
	private String description;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@NotBlank(message = "Açık pozisyon adedi alanı boş bırakılamaz!")
	@Column(name = "quota")
	private int quota;

	@Column(name = "release_date")
	private LocalDateTime releaseDate;

	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;

	@Column(name = "is_active")
	private boolean isActive;

}
