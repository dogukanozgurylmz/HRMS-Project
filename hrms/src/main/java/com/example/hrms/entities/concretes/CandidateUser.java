package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidate_users")
public class CandidateUser extends User {
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality_identity")
	private String nationalityIdentity;

	@Column(name = "birth_date")
	private String birthOfDate;

	public CandidateUser() {

	}

	public CandidateUser(int id, String emailAddress, String password, String passwordRepeat, String firstName, String lastName,
			String nationalityIdentity, String birthOfDate) {
		super(id, emailAddress, password, passwordRepeat);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityIdentity = nationalityIdentity;
		this.birthOfDate = birthOfDate;
	}

}
