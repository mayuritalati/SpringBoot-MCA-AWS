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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

	
	
	
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="URL NOT FOUND"),
			@ApiResponse(code=401,message="You r not authenticated"),
			@ApiResponse(code=403,message="Not Authorized..."),
					
			
			
	})
	@ApiOperation("get all accounts") //swaagger specific annotation
	@GetMapping
	public List<Account> getAllAccounts(){
		return as.findAll();
	}
	
	
	@ApiOperation("get  account by accno") //swaagger specific annotation
	@GetMapping("/{accno}")
	public Account getAccount(@PathVariable("accno") int accno){
		return as.findByAccno(accno);
	}
	

	
	@ApiOperation("delete account by accno") //swaagger specific annotation
	@DeleteMapping("/{accno}")
	public List<Account> deleteAccount(@PathVariable("accno") int accno){
		as.deleteAccount(accno);
		return as.findAll();
		
	}
	
	@ApiOperation("update account by accno") //swaagger specific annotation
	@PutMapping("/{accno}")
	public List<Account> updateAccount(@PathVariable("accno") int accno,@RequestBody Account account){
		as.updateAccount(account);
		return as.findAll();
		
	}
	
	

	@ApiOperation("add new account") //swaagger specific annotation
	@PostMapping
	public List<Account> addAccount(@RequestBody Account account){
		as.saveAccount(account);
		return as.findAll();
		
	}
	

	
	
	
	
	
}
