package com.mayuri.company.rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayuri.company.model.Employee;
import com.mayuri.company.service.EmployeeService;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {
	
	
	
	
	public EmployeeRestController() {
		System.out.println("EmployeeRestController constructor called.....");
	}

	@Qualifier(value = "employeeService")
	@Autowired
	EmployeeService employeeService;
	

	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.findAll();
		
	}
	
	/*
	 * @GetMapping("{empId}") public ResponseEntity<String>
	 * getEmployee(@PathVariable("empId") Integer empId){ return
	 * employeeService.findById(empId);
	 * 
	 * }
	 */
	 @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity healthcheck(@PathVariable("format") String format) {
	        if(format != null && !format.equals("")){
	            
	        
	            if(format.equals("short")){
	               return  (ResponseEntity)ResponseEntity.status(HttpStatus.OK);
	            } else if(format.equals("full")){
	            	HttpHeaders headers = new HttpHeaders();
	                return  new ResponseEntity(new ResponseStatus(new Date(), "OK"), headers, HttpStatus.OK);
	            }
	            return  new ResponseEntity("Bad Request",  HttpStatus.BAD_REQUEST);
	        } else {
	            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	
	
	@PostMapping
	public List<Employee> saveEmployee(@RequestBody Employee employee){
	
		employeeService.save(employee);
		return employeeService.findAll();
		
	}
	
	@PutMapping(value = "/{empId}")
	public List<Employee> updateEmployee(@PathVariable("empId") Integer empId, @RequestBody Employee employee){
		employeeService.update(employee);
		return employeeService.findAll();
		
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	@DeleteMapping("/{empId}")
	public List<Employee> updateEmployee(@PathVariable("empId") Integer empId){
		employeeService.delete(empId);
		return employeeService.findAll();
		
	}
	
}

class ResponseStatus{
    Date currentTime;
    String application;
    ResponseStatus(Date date, String app){
        currentTime = date;
        application = app;
    }
}

