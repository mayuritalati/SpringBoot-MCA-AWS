package com.pradeep.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradeep.bank.model.Account;
import com.pradeep.bank.repository.AccountReposiotry;

@Service("accountServiceMongoReposiotryImpl")
public class AccountServiceMongoRepositoryImpl implements AccountService {

	
	
	@Autowired
	private AccountReposiotry reposiotry;

	public AccountServiceMongoRepositoryImpl() {

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


	public boolean transferFund(int source, int destination, double amount) {

	
       return false;
	}

}
