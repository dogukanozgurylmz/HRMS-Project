package com.example.hrms.business.abstracts;

public interface ValidationService<T> {

	boolean isValid(T entity);
	
}
