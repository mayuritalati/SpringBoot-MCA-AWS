package com.mayuri.company.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.mayuri")
@Configuration
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("SpringConfiguration created......");
	}
	
	

}
