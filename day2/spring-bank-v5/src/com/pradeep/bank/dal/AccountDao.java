package com.pradeep.bank.dal;

import java.util.List;

import com.pradeep.bank.model.Account;

public interface AccountDao {

	boolean saveAccount(Account account);

	boolean updateAccount(Account account);

	Account findByAccno(int accno);

	boolean deleteAccount(int accno);

	List<Account> findAll();

}
