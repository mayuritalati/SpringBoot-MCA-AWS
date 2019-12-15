package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	
@Value("${server.port}")	
private int port;	
	
	
	public GreetController() {
		System.out.println("Grett Controller created....");
	}
	
@GetMapping("/message")	
public String message() {
	return "Greeting From Server ruuning on port "+port;
}
		
	
	
}
