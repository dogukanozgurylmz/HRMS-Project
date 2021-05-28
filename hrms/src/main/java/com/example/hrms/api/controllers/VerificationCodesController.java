package com.example.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/userverify")
public class VerificationCodesController {

	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}

	@GetMapping("/active/{code}")
	public Result activeUser(@PathVariable String code) {
		return verificationCodeService.activateUser(code);
	}
	
}
