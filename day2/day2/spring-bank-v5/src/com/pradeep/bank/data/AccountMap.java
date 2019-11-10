package com.pradeep.bank.data;

import java.util.HashMap;
import java.util.Map;

import com.pradeep.bank.model.Account;

public enum AccountMap {
	
INSTANCE;
	
private Map<Integer, Account> map;

private AccountMap() {

	map=new HashMap<>();
	
	Account a1=new Account("ram patil", 12000.00, "amxpc9856g", "ram@gmail.com", "7788667788");
	Account a2=new Account("pradeep chinchole", 2000.00, "yuxpc9858p", "pradeep@gmail.com", "7788667788");
	Account a3=new Account("rajesh sharma", 52000.00, "uuxpc9856o", "rajesh@gmail.com", "7788667788");
	Account a4=new Account("mohan patil", 72000.00, "wexpc9856i", "mohan@gmail.com", "7788667788");
	
	map.put(a1.getAccno(), a1);
	map.put(a2.getAccno(), a2);
	map.put(a3.getAccno(), a3);
	map.put(a4.getAccno(), a4);
	
	
	
}
	
	

public Map<Integer, Account> getMap() {
	return map;
}


}
