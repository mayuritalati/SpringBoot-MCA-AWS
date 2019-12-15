package com.mayuri;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@SpringBootApplication
@Configuration
public class CustomerServiceApplication {
	@Autowired
	RestTemplate restTemplate;
	 
	@Bean
	public RestTemplate restTemplate() 
	{
	    RestTemplate restTemplate = new RestTemplate();
	 
	    return restTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@GetMapping("/customers")
	public List<String> getCustomer(){
		return Arrays.asList("mayuri", "jain", "talati");
	}
	
	@GetMapping("/customers/inventory")
	public List<String> getCustomerInv(){
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:6060/inventory", String.class);
		return Arrays.asList(response.getBody());
	}
}



