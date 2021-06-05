package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPostings"})
@EqualsAndHashCode(callSuper = false)
@Table(name = "employers")
public class EmployerUser extends User {

	@NotBlank(message = "Şirketi adı alanı boş olamaz!")
	@NotNull
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "Web sitesi alanı boş olamaz!")
	@NotNull
	@Column(name = "web_address")
	private String webAddress;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "employerUser")
	private List<JobPosting> jobPostings;

	public EmployerUser(int id, String emailAddress, String password, String passwordRepeat, boolean verify, String companyName, String webAddress, String phoneNumber) {
		super(id, emailAddress, password, passwordRepeat, verify);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
	}

	

}
