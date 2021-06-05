package com.example.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank(message = "Ad alanı boş olamaz!")
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Soyad alanı boş olamaz!")
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "TC Kimlik No alanı boş olamaz!")
	@NotNull
	@Column(name = "national_identity")
	private String nationalIdentity;

	@NotNull
	@Column(name = "birth_date")
	private LocalDate birthOfDate;

	public CandidateUser(int id, String emailAddress, String password, String passwordRepeat, boolean verify, String firstName, String lastName,
			String nationalIdentity, LocalDate birthOfDate) {
		super(id, emailAddress, password, passwordRepeat, verify);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.birthOfDate = birthOfDate;
	}

}
