package com.mayuri.company.dao;

import java.util.List;

import com.mayuri.company.model.Employee;

public interface EmployeeDao {
	
	boolean save(Employee employee);
	boolean update(Employee employee);
	Employee findById(int id);
	boolean delete(int id);
	List<Employee> findAll();
}
