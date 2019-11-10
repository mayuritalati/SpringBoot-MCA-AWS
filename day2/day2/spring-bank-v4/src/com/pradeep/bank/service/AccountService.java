package com.pradeep.bank.service;

import java.util.List;

import com.pradeep.bank.model.Account;

public interface AccountService {

	boolean saveAccount(Account account);

	boolean updateAccount(Account account);

	Account findByAccno(int accno);

	boolean deleteAccount(int accno);

	List<Account> findAll();

}
