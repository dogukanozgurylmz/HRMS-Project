package com.example.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.UserCheckService;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapater implements UserCheckService {
	
	@Override
	public boolean confirm(String nationalityIdentity, String firstName, String lastName, String birthDate) {

		KPSPublicSoap client = new KPSPublicSoapProxy();
		
		try {
			client.TCKimlikNoDogrula(Long.parseLong(nationalityIdentity), firstName, lastName, Integer.parseInt(birthDate));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
