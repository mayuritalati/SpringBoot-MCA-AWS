package com.mayuri.company.data;

import java.util.HashMap;
import java.util.Map;

import com.mayuri.company.model.Employee;

public enum EmployeeMap {
	instance;
	
	Map<Integer, Employee> map = new HashMap<>();
	private EmployeeMap() {
		Employee emp1 = new Employee("emp1", 1000, "emp1@gmail.com", "1234567890", "1234567890");
		Employee emp2 = new Employee("emp2", 1000, "emp2@gmail.com", "234567890", "234567890");
		Employee emp3 = new Employee("emp3", 1000, "emp3@gmail.com", "34567890", "34567890");
		Employee emp4 = new Employee("emp4", 1000, "emp4@gmail.com", "4567890", "4567890");
		Employee emp5 = new Employee("emp5", 1000, "emp5@gmail.com", "567890", "567890");
		map.put(emp1.getEmpId(), emp1);
		map.put(emp2.getEmpId(), emp2);
		map.put(emp3.getEmpId(), emp3);
		map.put(emp4.getEmpId(), emp4);
		map.put(emp5.getEmpId(), emp5);
		
	}
	/**
	 * @return
	 */
	public Map<Integer, Employee> getMap() {
		return map;
	}
	
	

}
