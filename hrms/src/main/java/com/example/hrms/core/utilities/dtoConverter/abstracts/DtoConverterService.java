package com.example.hrms.core.utilities.dtoConverter.abstracts;

import java.util.List;

public interface DtoConverterService {

	<S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);
	
	public <T> Object dtoClassConverter(Object source, Class<T> baseClass);
	
}
