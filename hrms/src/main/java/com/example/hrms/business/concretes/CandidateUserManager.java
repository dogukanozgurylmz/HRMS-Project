package com.example.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateUserService;
import com.example.hrms.business.abstracts.UserCheckService;
import com.example.hrms.business.abstracts.ValidationService;
import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CandidateUserDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.CandidateUser;
import com.example.hrms.entities.concretes.User;

@Service
public class CandidateUserManager implements CandidateUserService {
	
	private CandidateUserDao candidateUserDao;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;
	private ValidationService<CandidateUser> validationService;
	private UserCheckService checkService;
	
	@Autowired
	public CandidateUserManager(CandidateUserDao candidateUserDao,
			UserDao userDao,
			VerificationCodeService verificationCodeService,
			ValidationService<CandidateUser> validationService,
			UserCheckService checkService) {
		
		this.candidateUserDao = candidateUserDao;
		this.validationService = validationService;
		this.checkService = checkService;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<CandidateUser>> getAll() {
		
		var result = candidateUserDao.findAll();
		return new SuccessDataResult<List<CandidateUser>>(result,"İş arayanlar listelendi.");
		
	}

	@Override
	public Result add(CandidateUser candidateUser) {
		
		if (!validationService.isValid(candidateUser)) {
			return new ErrorResult("Boş alan olamaz!");
		}else if (!realEmail(candidateUser.getEmailAddress())) {
			return new ErrorResult("Geçerli bir e-posta adresi yazınız.");
		}else if (!nationalityIdentityRule(candidateUser.getNationalityIdentity()) || candidateUserDao.getByNationalityIdentity(candidateUser.getNationalityIdentity())!=null) {
			return new ErrorResult("TC Kimlik Numarası doğru değil veya zaten kayıtlı.");
		}//else if (!checkService.confirm(candidateUser.getNationalityIdentity(), candidateUser.getFirstName(), candidateUser.getLastName(), candidateUser.getBirthOfDate())) {
		//	return new ErrorResult("Mernis doğrulaması hatalı!");
		//}
		else if (userDao.getByEmailAddress(candidateUser.getEmailAddress())!=null) {
			return new ErrorResult("Bu e-posta adresi zaten kayıtlı.");
		}
		candidateUser.setMailVerify(false);
		User savedUser = userDao.save(candidateUser);
		
		String returnedCode = verificationCodeService.createActivitionCode(savedUser);
		
		candidateUserDao.save(candidateUser);
		return new SuccessResult(candidateUser.getEmailAddress() + " adresine doğrulama kodu gönderildi.");
		
	}

	@Override
	public Result update(CandidateUser candidateUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(CandidateUser candidateUser) {
		// TODO Auto-generated method stub
		return null;
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