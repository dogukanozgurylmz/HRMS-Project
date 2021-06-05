package com.example.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

	@JsonIgnore
	private int id;
	
	private int resumeId;
	
	private String schoolName;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private int graduateId;
	
	private String graduateDescription;
	
	private String schoolDepartment;
	
	private LocalDate startedDate;
	
	private LocalDate endedDate;
	
}
