package com.pradeep.bank.presentation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.pradeep.bank.config.BankConfig;
import com.pradeep.bank.model.Account;
import com.pradeep.bank.service.AccountService;

@Lazy(value=true)

@Controller
public class BankMainApp {

	
	
	@Autowired
	// dependency
	private AccountService as;

	public BankMainApp() {
		System.out.println("BankMainApp created.....");
	}

	
	
	// setter injection
	public void setAs(AccountService as) {
		this.as = as;
		System.out.println("BankMainApp setAs method.....");
	}
	
	

	/*@Autowired
	// constructor injection
	public BankMainApp(AccountService as) {
		System.out.println("BankMainApp param constructor........");
		this.as = as;
	}*/

	public void addAccount(Account account) {

		if (as.saveAccount(account))
			System.out.println("Account saved succsssfully");
		else
			System.out.println("Problem in insrtion...");

	}

	public void updateAccount(Account account) {

		if (as.updateAccount(account))
			System.out.println("Account updated succsssfully");
		else
			System.out.println("Account doesn't exist...");

	}

	public void deleteAccount(int accno) {

		if (as.deleteAccount(accno))
			System.out.println("Account deleted succsssfully");
		else
			System.out.println("Account doesn't exist...");

	}

	public void showAccount(int accno) {

		Account account = as.findByAccno(accno);

		if (account != null)
			System.out.println("Account Details\n===============" + account);
		else
			System.out.println("Account doesn't exist...");

	}

	public void showAllAccounts() {

		System.out.println("All Accounts");
		System.out.println("=======================================");

		for (Account a : as.findAll())
			System.out.println(a);

	}

	
	
	@PostConstruct
	public void init() {
		System.out.println("BAnkMAin App   :initialization");
	}
	
	

	@PreDestroy
	public void destroy() {
		System.out.println("BAnkMAin App   :destruction");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		//create a spring container
	
AnnotationConfigApplicationContext c=new 
      AnnotationConfigApplicationContext(BankConfig.class);		
		
		
		
System.out.println("spring container created...");
				
		
		BankMainApp bma=c.getBean(BankMainApp.class);
		//BankMainApp bma=(BankMainApp)c.getBean("bankMainApp");
		
		
		
		
		bma.showAllAccounts();
		
		
		//shutdown the container
		
		c.registerShutdownHook();
			
		
		
	}
		
	
	
}
