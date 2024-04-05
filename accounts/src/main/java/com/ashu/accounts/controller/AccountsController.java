package com.ashu.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountsController {
	
	@GetMapping("/ready")
	public String ready() {
		return "Ready...";
	}
}
