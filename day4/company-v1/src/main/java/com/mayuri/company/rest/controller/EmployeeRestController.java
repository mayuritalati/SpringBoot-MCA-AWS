package com.mayuri.company.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	EmployeeService employeeService;
	

	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.findAll();
		
	}
	
	@GetMapping("{empId}")
	public Employee getEmployee(@PathVariable("empId") Integer empId){
		return employeeService.findById(empId);
		
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
