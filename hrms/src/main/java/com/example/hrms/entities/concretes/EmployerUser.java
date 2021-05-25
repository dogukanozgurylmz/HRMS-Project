package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "employer_users")
public class EmployerUser extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String webAddress;

	public EmployerUser() {

	}

	public EmployerUser(int id, String emailAddress, String password, String companyName, String webAddress) {
		super(id, emailAddress, password);
		this.companyName = companyName;
		this.webAddress = webAddress;
	}

}
