package com.example.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerUserService;
import com.example.hrms.business.abstracts.UsersVerifyService;
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
	private UserDao userDao;
	private UsersVerifyService usersVerifyService;
	
	public EmployerUserManager(EmployerUserDao employerUserDao,
			UserDao userDao,
			UsersVerifyService usersVerifyService) {
		
		super();
		this.employerUserDao = employerUserDao;
		this.userDao = userDao;
		this.usersVerifyService = usersVerifyService;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		
		return new SuccessDataResult<List<EmployerUser>>(employerUserDao.findAll(), "İş verenler listelendi.");
		
	}

	@Override
	public Result add(EmployerUser employerUser) {

		if (!realEmail(employerUser.getCompanyName().toLowerCase(), employerUser.getEmailAddress())) {
			return new ErrorResult("Geçerli bir e-posta adresi yazınız.");
		}else if (userDao.getByEmailAddress(employerUser.getEmailAddress())!=null) {
			return new ErrorResult("Bu e-posta adresi zaten kayıtlı.");
		}
		employerUserDao.save(employerUser);
		this.usersVerifyService.createVerifyCode(employerUser.getId());
		this.usersVerifyService.sendMail(employerUser.getEmailAddress());
		
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
