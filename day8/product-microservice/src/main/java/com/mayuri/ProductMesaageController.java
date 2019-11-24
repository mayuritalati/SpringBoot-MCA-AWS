package com.mayuri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductMesaageController {
	
	@Autowired
	public Environment env;
	
	@Value("${server.port}")
	public String port;
	
	@GetMapping("/message")
	public String getMessage() {
		return env.getProperty("server.port")+" : "+port;
	}

}
