package com.pradeep.bank.model;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pc_accounts")
public class Account {

@Id	
private int accno;

private String name;

@Column(name="bal")
private double balance;
private Date doc;
private String pan;
private String email;
private String mobile;

public Account() {
this.accno=new Random().nextInt(100000);
this.doc=new Date();
}

public Account(String name, double balance, String pan, String email, String mobile) {
	this.accno=new Random().nextInt(100000);
	this.doc=new Date();
	this.name = name;
	this.balance = balance;
	this.pan = pan;
	this.email = email;
	this.mobile = mobile;
}

public int getAccno() {
	return accno;
}

public void setAccno(int accno) {
	this.accno = accno;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public Date getDoc() {
	return doc;
}

public void setDoc(Date doc) {
	this.doc = doc;
}

public String getPan() {
	return pan;
}

public void setPan(String pan) {
	this.pan = pan;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

@Override
public String toString() {
	return "Account [accno=" + accno + ", name=" + name + ", balance=" + balance + ", doc=" + doc + ", pan=" + pan
			+ ", email=" + email + ", mobile=" + mobile + "]";
}

	
	
	
}
