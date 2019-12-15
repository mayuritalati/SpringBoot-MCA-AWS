package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class DbController {

	
	@Value("${jdbc.driver}")	
	private String driver;

	@Value("${jdbc.url}")	
	private String url;

	@Value("${jdbc.username}")	
	private String username;

	@Value("${jdbc.password}")	
	private String password;


	
	
	public DbController() {
		System.out.println("Grett Controller created....");
	}
	
@GetMapping("/dbdetails")	
public Map<String, String> message() {

	HashMap<String, String> hm=new HashMap<>();
	
	hm.put("driver",driver);
	hm.put("url",url);
	hm.put("username",username);
	hm.put("password",password);
	
	return hm;
	
}
		
	
	
}
