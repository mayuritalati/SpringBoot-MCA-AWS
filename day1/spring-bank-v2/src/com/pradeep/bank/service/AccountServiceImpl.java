package com.pradeep.bank.service;

import java.util.List;

import com.pradeep.bank.dal.AccountDao;
import com.pradeep.bank.model.Account;

public class AccountServiceImpl implements AccountService{

	//dependency
	private AccountDao accountDao;
	
	
	public AccountServiceImpl() {
	
	System.out.println("AccountServiceImpl  created......");
	}
	
	
	
	
	
	//constructor injection
	public AccountServiceImpl(AccountDao accountDao) {
		System.out.println("AccountServiceImpl  param contructoerr........");
		this.accountDao = accountDao;
		
	}


	//setter injection
	public void setAccountDao(AccountDao accountDao) {
		System.out.println("AccountServiceImpl  setAccountDao........");
		
		this.accountDao = accountDao;
	}



	@Override
	public boolean saveAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.saveAccount(account);
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.updateAccount(account);
	}

	@Override
	public Account findByAccno(int accno) {
		// TODO Auto-generated method stub
		return accountDao.findByAccno(accno);
	}

	@Override
	public boolean deleteAccount(int accno) {
		// TODO Auto-generated method stub
		return accountDao.deleteAccount(accno);
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}

}
