package com.pradeep.bank.rest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.bank.model.Account;
import com.pradeep.bank.service.AccountService;



@RequestMapping("/accounts")
@RestController
public class BankRestController {

	@Autowired
	@Qualifier("accountServiceImpl")
	// dependency
	private AccountService as;
	
	

	public BankRestController() {
		System.out.println("BankRestController created.....");
	}

	
	
	
	@GetMapping
	public List<Account> getAllAccounts(){
		return as.findAll();
	}
	
	
	@GetMapping("/{accno}")
	public Account getAccount(@PathVariable("accno") int accno){
		return as.findByAccno(accno);
	}
	

	
	@DeleteMapping("/{accno}")
	public List<Account> deleteAccount(@PathVariable("accno") int accno){
		as.deleteAccount(accno);
		return as.findAll();
		
	}
	
	@PutMapping("/{accno}")
	public List<Account> updateAccount(@PathVariable("accno") int accno,@RequestBody Account account){
		as.updateAccount(account);
		return as.findAll();
		
	}
	
	

	@PostMapping
	public List<Account> addAccount(@RequestBody Account account){
		as.saveAccount(account);
		return as.findAll();
		
	}
	

	
	
	
	
	
}
