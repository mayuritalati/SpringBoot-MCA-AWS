package com.pradeep.bank.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pradeep.bank.data.AccountMap;
import com.pradeep.bank.model.Account;


@Component("mapAccountDaoImpl")
public class MapAccountDaoImpl implements AccountDao {

	public MapAccountDaoImpl() {
	System.out.println("MapAccountDaoImpl default constructor created.. ");
	}
	
	
	@Override
	public boolean saveAccount(Account account) {

		return AccountMap.INSTANCE.getMap().put(account.getAccno(), account) == account;
	}

	@Override
	public boolean updateAccount(Account account) {

		if (AccountMap.INSTANCE.getMap().containsKey(account.getAccno())) {
			AccountMap.INSTANCE.getMap().put(account.getAccno(), account);
			return true;
		}

		return false;
	}

	@Override
	public Account findByAccno(int accno) {
		// TODO Auto-generated method stub
		return AccountMap.INSTANCE.getMap().get(accno);
	}

	@Override
	public boolean deleteAccount(int accno) {
		if (AccountMap.INSTANCE.getMap().containsKey(accno)) {
			AccountMap.INSTANCE.getMap().remove(accno);
			return true;
		}

		return false;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(AccountMap.INSTANCE.getMap().values());
	}

}
