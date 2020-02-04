package com.revature.service;

import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao newAcct = new AccountDaoImpl();
	Scanner scan = new Scanner(System.in);

	@Override
	public void createAccount() {		
		
		System.out.println("Please enter your new username associated with this account.");
		String uname = scan.next();		
		System.out.println("Please enter the amount of money you would like to start in this account.");
		int amount = scan.nextInt();
		
		newAcct.insertAccount(uname, amount);		
	}

	@Override
	public void viewAccount() {	
		
		System.out.println("Please enter the username for the account you wish to view.");
		String uname = scan.next();
		System.out.println(newAcct.selectAccount(uname));		
	}

	@Override
	public void withdraw() {
		
		System.out.println("Please enter the username for the account you wish to withdraw from.");
		String uname = scan.next();
		System.out.println("Enter the amount of money you would like to withdraw from this account.");
		int amount = scan.nextInt();
		
		newAcct.withdrawAccount(uname, amount);		
	}
	
	@Override
	public void deposit() {
		
		System.out.println("Please enter the username for the account you wish to deposit into.");
		String uname = scan.next();
		System.out.println("Enter the amount of money you would like to depost into this account.");
		int amount = scan.nextInt();
		
		newAcct.depositAccount(uname, amount);	
		
	}

	@Override
	public void removeAccount() {
		
		System.out.println("Please enter the username for the account you wish to delete.");
		String uname = scan.next();
		newAcct.deleteAccount(uname);		
	}

}
