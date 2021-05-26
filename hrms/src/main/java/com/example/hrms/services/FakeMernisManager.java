package com.example.hrms.services;

public class FakeMernisManager {

	public boolean isVerify(String firstName, String lastName, String nationalityIdentity, String birthYear) {
		
		if (firstName != null || lastName != null || nationalityIdentity != null || birthYear != null) {
			return true;
		}
		return false;
	}
	
}
