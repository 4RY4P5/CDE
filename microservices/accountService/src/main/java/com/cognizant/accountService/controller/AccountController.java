package com.cognizant.accountService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.accountService.model.Account;

@RestController
public class AccountController {
	@GetMapping("/accounts/{number}")
	public Account getAccountDetails(@PathVariable String number)
	{
		return new Account(number, "savings" , 234343 );
	}
}
