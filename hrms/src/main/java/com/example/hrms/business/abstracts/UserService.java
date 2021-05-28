package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	
	DataResult<User> getByEmail(String email);
	
}
