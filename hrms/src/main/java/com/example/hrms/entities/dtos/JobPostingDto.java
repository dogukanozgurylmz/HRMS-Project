package com.example.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDto {
	
	private int id;
	
	private String employerUserCompanyName;
	
	private String jobPositionPosition;
	
	private int quota;
	
	private LocalDate releaseDate;
	
	private LocalDate applicationDeadline;
	
}
