package com.mayuri;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InventoryServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@GetMapping("/inventory")
	public List<String> getCustomer(){
		logger.info("--Application Started--");
		return Arrays.asList("mobile", "tv", "phone");
	}

}
