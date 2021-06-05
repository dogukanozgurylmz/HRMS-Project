package com.example.hrms.entities.dtos;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDto {
	
	@JsonIgnore
	private int id;
	
	private int resumeId;
	
	@NotBlank(message = "Teknoloji açıklaması boş olamaz.")
	private String description;

}