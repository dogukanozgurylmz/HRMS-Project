package com.example.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.UsersVerifyService;
import com.example.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/userverify")
@CrossOrigin
public class UsersVerifyController {

	private UsersVerifyService usersVerifyService;

	@Autowired
	public UsersVerifyController(UsersVerifyService usersVerifyService) {
		super();
		this.usersVerifyService = usersVerifyService;
	}

	@GetMapping("/{verifyCode}")
	public Result activeUser(@PathVariable("verifyCode") String verifyCode) {
		return usersVerifyService.verifyUser(verifyCode);
	}
	
}
