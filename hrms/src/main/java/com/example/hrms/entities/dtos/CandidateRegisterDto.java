package com.example.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRegisterDto {
	
	private String firstName;
	
	private String lastName;
	
	private String nationalIdentity;
	
	private LocalDate birthOfDate;
	
	private String emailAddress;
	
	private String password;
	
	private String passwordRepeat;
	
}
