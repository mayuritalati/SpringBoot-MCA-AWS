package com.mayuri.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayuri.company.model.Employee;
import com.mayuri.company.repository.EmployeeRepository;

@Service("employeeMysqlServiceImpl")
public class EmployeeMysqlServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeMysqlServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("EmployeeServiceImpl const injection is called...");
		this.employeeRepository = employeeRepository;
	}
	
	


	public EmployeeMysqlServiceImpl() {
	}

	@Override
	public boolean save(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp == employee;
	}

	@Override
	public boolean update(Employee employee) {
		Employee employeeDB =  employeeRepository.findById(employee.getEmpId()).get();
		if(employeeDB != null) {
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}

	@Override
	public Employee findById(int id) {
		Employee employee =  employeeRepository.findById(id).get();
		return employee;
	}

	@Override
	public boolean delete(int id) {
		Employee employee =  employeeRepository.findById(id).get();
		if(employee != null) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
