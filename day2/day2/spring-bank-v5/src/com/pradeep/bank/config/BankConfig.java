package com.pradeep.bank.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;



@ComponentScan(basePackages= {"com"})
@Configuration
public class BankConfig {

	public BankConfig() {
	System.out.println("BankConfig Created.....");
	}
	
}
