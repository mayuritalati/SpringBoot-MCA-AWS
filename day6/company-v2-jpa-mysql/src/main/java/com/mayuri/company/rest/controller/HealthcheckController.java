package com.mayuri.company.rest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
@RestController
class HealthcheckController {

	 @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> healthcheck(@RequestParam("format") String format) {
		 HttpHeaders header = new HttpHeaders();
		 try{
	            header.add("Content-Type", "application/json");
	            if(format != null){
	            
	            if(format.equals("short")){
	               return  new  ResponseEntity(header, HttpStatus.OK);
	            } else if(format.equals("full")){
	                return  ResponseEntity.accepted().headers(header).body(new ResponseStatusCus(new Date(), "OK"));
	            }
	            }
	        }catch(Exception e){
	            
	        }
		 return  new ResponseEntity(header, HttpStatus.BAD_REQUEST);
	        
	        
	    }
    @PutMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheckPut() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheckPost() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheckDelete() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

}
class ResponseStatusCus{
    String currentTime;
    String application;
    ResponseStatusCus(Date date, String app){
    	date = new Date(System.currentTimeMillis());

    	// Conversion
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    	sdf.setTimeZone(TimeZone.getTimeZone("CET"));
    	String text = sdf.format(date);
    	currentTime = text;
        application = app;
    }
	@Override
	public String toString() {
		return "ResponseStatusCus [currentTime=" + currentTime + ", application=" + application + "]";
	}
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	
	
    
}

@Configuration
 class WebConfig 
{
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customJson()
    {
        return builder -> {
 
            // human readable
            builder.indentOutput(true);
 
           
 
            // all lowercase with under score between words
            builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        };
    }
}

