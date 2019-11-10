package com.mayuri.company.main;

import com.mayuri.company.dao.EmployeeDao;
import com.mayuri.company.dao.EmployeeDaoImpl;
import com.mayuri.company.model.Employee;
import com.mayuri.company.service.EmployeeService;
import com.mayuri.company.service.EmployeeServiceImpl;

/**
 * @author mayuri
 *
 */
public class CompanyMainApp {
	
	
	
	public CompanyMainApp() {
		System.out.println("CompanyMainApp constr called....");
	}

	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		System.out.println("CompanyMainApp setter injection called....");
		this.employeeService = employeeService;
	}
	
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		EmployeeService es = new EmployeeServiceImpl(empDao);
				
		CompanyMainApp companyMainApp  = new CompanyMainApp();
		companyMainApp.setEmployeeService(es);
		companyMainApp.showAllEmployee();
	}
	
	private void showAllEmployee() {
		System.out.println("===========================================");
		System.out.println("show all employee from CompanyMainApp...");
		employeeService.findAll().forEach(emp -> System.out.println(emp));
		System.out.println("===========================================");
	}
	
	private boolean save(Employee employee) {
		System.out.println("save employee from CompanyMainApp...");
		return employeeService.save(employee);
	}
	
	private boolean update(Employee employee) {
		System.out.println("update employee from CompanyMainApp...");
		return employeeService.update(employee);
	}
	
	private void delete(int empId) {
		System.out.println("delete employee from CompanyMainApp...");
		employeeService.delete(empId);
	}
	
	private void findById(int empId) {
		System.out.println("findById employee from CompanyMainApp...");
		employeeService.findById(empId);
	}

}
