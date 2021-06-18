package com.example.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.business.abstracts.CandidateUserService;
import com.example.hrms.business.abstracts.EmployerUserService;
import com.example.hrms.business.abstracts.UsersVerifyService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.EmployerUser;

@Service
public class AuthManager implements AuthService {
	
	private CandidateUserService candidateUserService;
	private EmployerUserService employerUserService;
	private UsersVerifyService verifyService;

	@Autowired
	public AuthManager(CandidateUserService candidateUserService, EmployerUserService employerUserService,
			UsersVerifyService verifyService) {
		this.candidateUserService = candidateUserService;
		this.employerUserService = employerUserService;
		this.verifyService = verifyService;
	}

	@Override
	public Result registerEmployer(EmployerUser employerUser) {
		
		if (!employerUser.getPassword().equals(employerUser.getPasswordRepeat())) {
			return new ErrorResult("Şifreler uyuşmuyor!");
		}
		if (!realEmail(employerUser.getEmailAddress())) {
			return new ErrorResult("Geçerli bir e-posta adresi yazınız.");
		}
		
		var result = this.employerUserService.add(employerUser);
		if (result.isSuccess()) {
			this.verifyService.createVerifyCode(employerUser.getId());
			this.verifyService.sendMail(employerUser.getEmailAddress());
		}
		return new ErrorResult("Bir şeyler ters gitti. Lütfen Tekrar deneyin.");
		
	}

	@Override
	public Result registerCandidate(CandidateUser candidateUser) {

		if (!realEmail(candidateUser.getEmailAddress())) {
			return new ErrorResult("Geçerli bir e-posta adresi yazınız.");
		}
		if (!nationalityIdentityRule(candidateUser.getNationalIdentity())) {
			return new ErrorResult("TC Kimlik Numarası doğru değil veya zaten kayıtlı.");
		}
		
		var result = this.candidateUserService.add(candidateUser);
		if (result.isSuccess()) {
			this.verifyService.createVerifyCode(candidateUser.getId());
			this.verifyService.sendMail(candidateUser.getEmailAddress());
		}
		return new ErrorResult("Bir şeyler ters gitti. Lütfen Tekrar deneyin.");
		
	}
	
	private boolean realEmail(String email) {
		String regex = "[a-z0-9!#$%&\'*+/=?^_\'{|}~-]+(?:.[a-z0-9!#$%&\'*+/=?^_\'{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	private boolean nationalityIdentityRule(String nationalityIdentity) {
		String regex = "^[1-9]{1}[0-9]{9}[02468]{1}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nationalityIdentity);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

}
