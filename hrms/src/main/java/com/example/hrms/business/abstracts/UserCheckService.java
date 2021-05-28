package com.example.hrms.business.abstracts;

public interface UserCheckService {
	boolean confirm(String nationalityIdentity, String firstName, String lastName, String birthDate);
}
