package com.example.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingPostDto {

	@JsonIgnore
	private int id;
	
	private int employerUserId;
	
	private int jobPositionId;
	
	private int quota;
	
	private int minSalary;
	
	private int maxSalary;
	
	private int cityId;
	
	private LocalDate releaseDate;
	
	private LocalDate applicationDeadline;
	
	private String description;
	
}