package com.mayuri.company.spring.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	public HelloController() {
	System.out.println("HelloController created.....");
	}
	
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/greet")
	public ModelAndView greet() {
		return new ModelAndView("greet", "message", "Welcome To Sring");
	}
	
	@RequestMapping("/today")
	public @ResponseBody  String today() {
		return "Today is  :"+new Date();
	}
	
	
	
	
	
}
