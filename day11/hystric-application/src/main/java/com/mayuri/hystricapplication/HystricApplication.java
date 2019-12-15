package com.mayuri.hystricapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@EnableHystrix
@RestController
@SpringBootApplication
public class HystricApplication {

	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	public static void main(String[] args) {
		SpringApplication.run(HystricApplication.class, args);
	}
	
	@GetMapping("users")
	public List<String> getUsers(){
		return java.util.Arrays.asList("mayuri", "jain", "talati");
	}
	
	
	@GetMapping("users/posts")
	@HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
			})
	public String getPosts(){
		   String response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts"
	                , String.class).getBody();
		   return response;
	}
	
	private String fallbackMethod() {
		return "this is not available as of now. Please try aftersome time.";

	}
	

}
