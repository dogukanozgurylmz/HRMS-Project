package com.example.hrms.core.adapters;

import org.springframework.stereotype.Service;

import com.example.hrms.services.FakeMernisManager;

@Service
public class FakeMernisManagerAdapter implements FakeMernisService {

	@Override
	public boolean isVerify(String firstName, String lastName, String nationalityIdentity, String birthYear)  {
		
		FakeMernisManager manager = new FakeMernisManager();
		
		boolean result = manager.isVerify(firstName, lastName, nationalityIdentity, birthYear);
		
		if (!result) {
			return false;
		}
		return true;
		
	}

}
