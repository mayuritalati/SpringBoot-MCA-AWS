package com.pradeep.bank.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pradeep.bank.model.Account;
import com.pradeep.bank.service.AccountService;

@Controller
public class BankSpringController {

	
	
	
	@Autowired
	// dependency
	private AccountService as;
	
	

	public BankSpringController() {
		System.out.println("BankSpringController created.....");
	}

	
	@RequestMapping(value="/getallaccounts",method=RequestMethod.GET)
	public String getAllAccounts(ModelMap map) {
	
		map.addAttribute("accounts",as.findAll());
		return "accountList";
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String getAllAccounts(@RequestParam("accno") int accno,ModelMap map) {
		as.deleteAccount(accno);
		map.addAttribute("accounts",as.findAll());
		return "accountList";
	}
	
	
	

	@RequestMapping(value="/edit/{accno}",method=RequestMethod.GET)
	public String editAccount(@PathVariable("accno") int accno,ModelMap map) {
		map.addAttribute("accounts",as.findAll());
		map.addAttribute("account",as.findByAccno(accno));
		
		return "editAccount";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String editAccount(ModelMap map) {
		map.addAttribute("accounts",as.findAll());
		map.addAttribute("account",new Account());
		
		return "addAccount";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateAccount( @ModelAttribute("account") Account account, ModelMap map) {
		
		as.updateAccount(account);
		
		map.addAttribute("accounts",as.findAll());
		
		return "accountList";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addAccount( @ModelAttribute("account") Account account, ModelMap map) {
		
		as.saveAccount(account);
		
		map.addAttribute("accounts",as.findAll());
		
		return "accountList";
	}
	
	
	
}
