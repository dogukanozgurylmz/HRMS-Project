package com.example.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingFilter {

	private List<Integer> cityId;
	
	private List<Integer> jobPositionId;
	
	private List<Integer> workingTimeId;
	
	private List<Integer> workTypeId;
	
}
