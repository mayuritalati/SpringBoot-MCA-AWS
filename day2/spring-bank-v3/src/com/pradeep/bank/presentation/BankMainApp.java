package com.pradeep.bank.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pradeep.bank.dal.MapAccountDaoImpl;
import com.pradeep.bank.model.Account;
import com.pradeep.bank.service.AccountService;
import com.pradeep.bank.service.AccountServiceImpl;

public class BankMainApp {

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

	// constructor injection
	public BankMainApp(AccountService as) {
		System.out.println("BankMainApp param constructor........");
		this.as = as;
	}

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

	
	
	
	public void init() {
		System.out.println("BAnkMAin App   :initialization");
	}
	
	

	public void destroy() {
		System.out.println("BAnkMAin App   :destruction");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		//create a spring container
		ClassPathXmlApplicationContext c=new 
				ClassPathXmlApplicationContext("beans-autowire.xml");
		
		System.out.println("spring container created...");
		
		
		BankMainApp bma=c.getBean(BankMainApp.class);
		
		
		
		bma.showAllAccounts();
		
		
		//shutdown the container
		
		c.registerShutdownHook();
		
		 
		
		
		
		
		
	}
		
	
	
}
