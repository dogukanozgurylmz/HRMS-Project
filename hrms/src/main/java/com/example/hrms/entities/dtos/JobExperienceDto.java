package com.example.hrms.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDto {
	@JsonIgnore
	private int id;
	
	private int resumeId;
	
	private String companyName;
	
	@Past(message = "Başlangıç tarihi gelecek zaman olamaz.")
	private LocalDate startedDate;
	
	private LocalDate endedDate;
	
	private int jobTitleId;
}
