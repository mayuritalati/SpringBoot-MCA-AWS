package com.pradeep.bank.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.pradeep.bank.model.Account;
import com.pradeep.bank.repository.AccountReposiotry;

@Service("accountMySqlServiceImpl")
public class AccountServiceMySQLRepositoryImpl implements AccountService {

	
	@Resource
	private PlatformTransactionManager transactionManager;
	
	
	@Autowired
	private AccountReposiotry reposiotry;

	public AccountServiceMySQLRepositoryImpl() {

		System.out.println("AccountServiceMySQLRepositoryImpl  created......");
	}

	@Override
	public boolean saveAccount(Account account) {
		// TODO Auto-generated method stub
		return reposiotry.save(account) == account;
	}

	@Override
	public boolean updateAccount(Account account) {

		Account account1 = reposiotry.findById(account.getAccno()).get();

		if (account1 != null) {
			reposiotry.save(account);
			return true;
		}

		return false;
	}

	@Override
	public Account findByAccno(int accno) {
		// TODO Auto-generated method stub
		return reposiotry.findById(accno).get();
	}

	@Override
	public boolean deleteAccount(int accno) {

		Account account1 = reposiotry.findById(accno).get();

		if (account1 != null) {
			reposiotry.delete(account1);

			return true;
		}

		return false;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return reposiotry.findAll();
	}

	
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void transferFund(){
		
		 TransactionDefinition def = new DefaultTransactionDefinition();

		 TransactionStatus status = transactionManager.getTransaction(def);

		System.out.println("Second TransferFund :"+status.isNewTransaction());
		
		
		
		
		Account a=new Account();
		
		reposiotry.save(a);
		
			System.out.println(a);
		
		System.out.println("********* Transfering the fund********");
	}
	
	
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean transferFund(int source, int destination, double amount) {

		


		 TransactionDefinition def = new DefaultTransactionDefinition();

		 TransactionStatus status = transactionManager.getTransaction(def);

		System.out.println("First  TransferFund :"+status.isNewTransaction());
		

		
		Account sourceAccount = reposiotry.findById(source).get();
		Account destinationAccount = reposiotry.findById(destination).get();

		if (sourceAccount != null && destinationAccount != null) {

			if (amount <= sourceAccount.getBalance()) {
				sourceAccount.setBalance(sourceAccount.getBalance() - amount);
				destinationAccount.setBalance(destinationAccount.getBalance() + amount);

				reposiotry.save(sourceAccount);
				reposiotry.save(destinationAccount);

				transferFund();
				
				
				return true;

			} else
				throw new RuntimeException("Insufficent Balance in Account");

		}

		return false;
	}

}
