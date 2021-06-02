package com.example.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDto {
	
	private String companyName;
	
	private String position;
	
	private int quota;
	
	private LocalDateTime releaseDate;
	
	private LocalDateTime applicationDeadline;
	
}
