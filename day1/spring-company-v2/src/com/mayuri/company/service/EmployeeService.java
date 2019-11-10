package com.mayuri.company.service;

import java.util.List;

import com.mayuri.company.model.Employee;

public interface EmployeeService {
	
	boolean save(Employee employee);
	boolean update(Employee employee);
	Employee findById(int id);
	boolean delete(int id);
	List<Employee> findAll();
	
}
