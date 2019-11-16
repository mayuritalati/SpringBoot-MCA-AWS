package com.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	public UserController() {
	System.out.println("UserController created...");
	}
	
	@RequestMapping("/user")
	public @ResponseBody Principal user(Principal principal){
		return principal;
	}
	 
}
