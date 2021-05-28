package com.example.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerUserService;
import com.example.hrms.business.abstracts.ValidationService;
import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployerUserDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.EmployerUser;
import com.example.hrms.entities.concretes.User;

@Service
public class EmployerUserManager implements EmployerUserService {

	private EmployerUserDao employerUserDao;
	private ValidationService<EmployerUser> validationService;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;
	
	public EmployerUserManager(EmployerUserDao employerUserDao,
			ValidationService<EmployerUser> validationService,
			UserDao userDao,
			VerificationCodeService verificationCodeService) {
		
		super();
		this.employerUserDao = employerUserDao;
		this.validationService = validationService;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		
		return new SuccessDataResult<List<EmployerUser>>(employerUserDao.findAll(), "İş verenler listelendi.");
		
	}

	@Override
	public Result add(EmployerUser employerUser) {

		if (!validationService.isValid(employerUser)) {
			return new ErrorResult("Boş alan olamaz!");
		}else if (!realEmail(employerUser.getCompanyName().toLowerCase(), employerUser.getEmailAddress())) {
			return new ErrorResult("Geçerli bir e-posta adresi yazınız.");
		}else if (userDao.getByEmailAddress(employerUser.getEmailAddress())!=null) {
			return new ErrorResult("Bu e-posta adresi zaten kayıtlı.");
		}
		employerUser.setMailVerify(false);
		User savedUser = userDao.save(employerUser);
		
		String returnedCode = verificationCodeService.createActivitionCode(savedUser);
		return new SuccessResult(employerUser.getEmailAddress() + " adresine doğrulama kodu gönderildi.");
	}
	
	private boolean realEmail(String companyName, String email) {
		String regex = companyName + "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
	

}
