package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String webAddress;
	
	@Column(name = "phone_number")
	private String phone;
	
	@OneToMany(mappedBy = "employerUser")
	private List<JobPosting> jobPostings;

	public EmployerUser(int id, String email, String password, boolean isMailVerify, String companyName, String webAddress, String phone) {
		super(id, email, password, isMailVerify);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phone = phone;
	}

}
