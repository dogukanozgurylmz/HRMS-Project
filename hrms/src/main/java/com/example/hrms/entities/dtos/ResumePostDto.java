package com.example.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumePostDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	
	private int candidateUserId;
	
	private String githubLink;
	
	private String linkedLink;
	
	private String photo;
	
	private String description;
	
	private LocalDateTime updatedDate;
	

}
