package com.example.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.UsersVerifyService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.dataAccess.abstracts.UsersVerifyDao;
import com.example.hrms.entities.concretes.User;
import com.example.hrms.entities.concretes.UsersVerify;

@Service
public class UsersVerifyManager implements UsersVerifyService {
	
	private UsersVerifyDao usersVerifyDao;
	private UserDao userDao;

	@Autowired
	public UsersVerifyManager(UsersVerifyDao usersVerifyDao, UserDao userDao) {
		super();
		this.usersVerifyDao = usersVerifyDao;
		this.userDao = userDao;
	}

	@Override
	public String createVerifyCode(int id) {

		String vCode = UUID.randomUUID().toString();
		UsersVerify usersVerify = new UsersVerify();
		LocalDate date = (LocalDate.now());
		usersVerify.setUserId(id);
		usersVerify.setCreatedDate(Date.valueOf(date));
		usersVerify.setVerifyCode(UUID.randomUUID().toString());
		this.usersVerifyDao.save(usersVerify);
		return vCode;
		
	}

	@Override
	public void sendMail(String email) {

		System.out.println("Doğrulama Maili Gönderildi : " + email);
		
	}

	@Override
	public Result verifyUser(String code) {
		
		if (!this.usersVerifyDao.existsByVerifyCode(code)) {
			return new ErrorResult("Hatalı Doğrulama İşlemi");
		}
		UsersVerify usersVerify = usersVerifyDao.getByVerifyCode(code);
		if (this.usersVerifyDao.getOne(usersVerify.getId()).isConfirmed()) {
			return new ErrorResult("Doğrulama işlemi daha önce yapıldı");
		}
		LocalDate date = (LocalDate.now());
		usersVerify.setConfirmed(true);
		usersVerify.setConfirmedDate(Date.valueOf(date));
		usersVerifyDao.save(usersVerify);
		User user = new User();
		user = userDao.getOne(usersVerify.getUserId());
		user.setVerify(true);
		userDao.save(user);
		return new SuccessResult("Doğrulama Başarılı");	
		
	}

}
