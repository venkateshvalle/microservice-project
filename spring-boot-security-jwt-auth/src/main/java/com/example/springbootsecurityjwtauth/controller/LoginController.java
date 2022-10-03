package com.example.springbootsecurityjwtauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping(" / ")
	public String homePage() {
		return " Home page ";
	}
}