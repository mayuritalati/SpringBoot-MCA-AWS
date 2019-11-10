package com.mayuri.company.dao;

import java.util.ArrayList;
import java.util.List;

import com.mayuri.company.data.EmployeeMap;
import com.mayuri.company.model.Employee;
/**
 * 
 * @author mayuri jain
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {
	
	

	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl default const called...");
	}

	@Override
	public boolean save(Employee employee) {
		return EmployeeMap.instance.getMap().put(employee.getEmpId(), employee) == employee;
	}

	@Override
	public boolean update(Employee employee) {
		if(EmployeeMap.instance.getMap().containsKey(employee.getEmpId())) {
			EmployeeMap.instance.getMap().put(employee.getEmpId(), employee);
			return true;
		}
		return false;
	}

	@Override
	public Employee findById(int id) {
		if(EmployeeMap.instance.getMap().containsKey(id)) {
			return EmployeeMap.instance.getMap().get(id);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		if(EmployeeMap.instance.getMap().containsKey(id)) {
			EmployeeMap.instance.getMap().remove(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> findAll() {
		return new ArrayList<>(EmployeeMap.instance.getMap().values());
	}

}
