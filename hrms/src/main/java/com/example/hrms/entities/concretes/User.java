package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="password")
	private String password;
	
	private String passwordRepeat;
	
	public User() {
		
	}

	public User(int id, String emailAddress, String password, String passwordRepeat) {
		super();
		this.id = id;
		this.emailAddress = emailAddress;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}

}
