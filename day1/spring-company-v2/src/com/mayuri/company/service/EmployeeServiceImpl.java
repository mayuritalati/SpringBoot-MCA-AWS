package com.mayuri.company.service;

import java.util.List;

import com.mayuri.company.dao.EmployeeDao;
import com.mayuri.company.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		System.out.println("EmployeeServiceImpl const injection is called...");
		this.employeeDao = employeeDao;
	}
	
	

	public EmployeeServiceImpl() {
	}

	@Override
	public boolean save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	@Override
	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.update(employee);
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return employeeDao.delete(id);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

}
