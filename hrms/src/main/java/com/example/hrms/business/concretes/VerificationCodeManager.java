package com.example.hrms.business.concretes;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.dataAccess.abstracts.VerificationCodeDao;
import com.example.hrms.entities.concretes.User;
import com.example.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {
	
	VerificationCodeDao verificationCodeDao;
	UserDao userDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao, UserDao userDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<VerificationCode>> getAll() {
		
		return new SuccessDataResult<List<VerificationCode>>(verificationCodeDao.findAll(),"Listelendi");
		
	}
	
	String generatedCode = "";

	@Override
	public String createActivitionCode(User user) {
		
		for (int i = 0; i == 0; i = 0) {
			generatedCode = randomCodeGenarator(20); // Random kod olustur
			if (getByCode(generatedCode) == null) {
				break;
			}
		}
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setId(user.getId());
		verificationCode.setCode(generatedCode);
		verificationCodeDao.save(verificationCode);
		return generatedCode;
		
	}

	@Override
	public Result activateUser(String activationCode) {

		User user = userDao.getOne(verificationCodeDao.findByCode(activationCode).getId());
		user.setMailVerify(true);
		VerificationCode verificationCode = verificationCodeDao.findByCode(activationCode);
		verificationCode.setVerified(true);
		userDao.save(user);
		verificationCodeDao.save(verificationCode);
		return new SuccessResult("Kullanici aktivasyonu gerceklesti");
		
	}

	@Override
	public VerificationCode getByCode(String code) {

		return this.verificationCodeDao.findByCode(code);
		
	}
	
	private final String whatsUp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private SecureRandom mixer = new SecureRandom();

	private String randomCodeGenarator(int lenght) {
		StringBuilder randomValueConstructor = new StringBuilder(lenght);
		for (int i = 0; i < lenght; i++) {
			randomValueConstructor.append(whatsUp.charAt(mixer.nextInt(whatsUp.length())));
		}
		return randomValueConstructor.toString();
	}

}
