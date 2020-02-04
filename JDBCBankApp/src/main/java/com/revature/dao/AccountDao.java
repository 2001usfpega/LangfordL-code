package com.revature.dao;

import com.revature.model.Account;

public interface AccountDao {
	//CRUD ONLY
	
	// CREATE
	public void insertAccount(String uname, int amount);

	// READ
	public Account selectAccount(String uname);

	// UPDATE
	public void withdrawAccount(String uname, int amount);
	
	public void depositAccount(String uname, int amount);	
	

	// DELETE
	public void deleteAccount(String uname);
	

}
