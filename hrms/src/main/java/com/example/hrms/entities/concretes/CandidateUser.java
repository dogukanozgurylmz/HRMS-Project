package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
public class CandidateUser extends User {
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality_identity")
	private String nationalityIdentity;

	@Column(name = "birth_date")
	private String birthOfDate;

	public CandidateUser(int id, String emailAddress, String password, boolean isMailVerify, String firstName, String lastName,
			String nationalityIdentity, String birthOfDate) {
		super(id, emailAddress, password, isMailVerify);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityIdentity = nationalityIdentity;
		this.birthOfDate = birthOfDate;
	}

}
