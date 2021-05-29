package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
}
