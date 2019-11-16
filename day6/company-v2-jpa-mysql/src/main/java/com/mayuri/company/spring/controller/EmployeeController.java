package com.mayuri.company.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mayuri.company.model.Employee;
import com.mayuri.company.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier(value = "employeeMysqlServiceImpl")
	EmployeeService employeeService;
	
	@RequestMapping(value = "/greeting")
	public String greeting(ModelMap model ){
		model.addAttribute("message", "Hello Welcome");
		return "greeting";
		
	}
	
	@RequestMapping(value = "/getallemployee", method = RequestMethod.GET)
	public String getAllEmployee(ModelMap model ){
		model.addAttribute("employees", employeeService.findAll());
		return "getallemployee";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(ModelMap model ){
		System.out.println("add...."+new Date());
		Employee empToBeSaved = new Employee();
		model.addAttribute("employee", empToBeSaved);
		model.addAttribute("employees", employeeService.findAll());
		return "addemployee";
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee, ModelMap model){
		Employee empToBeSaved = employee;
		empToBeSaved.setDoj(new Date());
		employeeService.save(empToBeSaved);
		model.addAttribute("employees", employeeService.findAll());
		
		return "getallemployee";
		
	}
	
	@RequestMapping(value = "/edit/{empId}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable("empId") Integer empId, ModelMap model ){
		System.out.println("Edit...."+new Date());
		model.addAttribute("employee", employeeService.findById(empId));
		model.addAttribute("employees", employeeService.findAll());
		return "editemployee";
		
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee, ModelMap model){
		Employee empToBeSaved = employee;
		empToBeSaved.setDoj(new Date());
		employeeService.update(empToBeSaved);
		model.addAttribute("employees", employeeService.findAll());
		return "getallemployee";
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String updateEmployee(@RequestParam("empId") Integer empId, ModelMap model){
		employeeService.delete(empId);
		model.addAttribute("employees", employeeService.findAll());
		return "getallemployee";
		
	}
	
}
