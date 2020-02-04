package com.revature.model;

public class Account {
	
	private int accountid;
	private String username;
	private int balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int accountid, String username, int balance) {
		super();
		this.accountid = accountid;
		this.username = username;
		this.balance = balance;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", username=" + username + ", balance=" + balance + "]";
	}
}
