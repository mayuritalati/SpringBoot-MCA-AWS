package com.mayuri.company.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.mayuri.company.config.SpringConfiguration;
import com.mayuri.company.model.Employee;
import com.mayuri.company.service.EmployeeService;

/**
 * @author mayuri
 *
 */
@Component
public class CompanyMainApp {
	
	
	
	public CompanyMainApp() {
		System.out.println("CompanyMainApp constr called....");
	}

	
	private EmployeeService employeeService;
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		System.out.println("CompanyMainApp setter injection called....");
		this.employeeService = employeeService;
	}
	
	public static void main(String[] args) {
		System.out.println("annotation spring v1 5..");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		CompanyMainApp companyMainApp  = (CompanyMainApp) applicationContext.getBean(CompanyMainApp.class);
		companyMainApp.showAllEmployee();
		applicationContext.registerShutdownHook();
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
	
	public void init(){
		System.out.println("init is called...");
	}
	
	public void destroy(){
		System.out.println("destroy is called...");
	}

}
