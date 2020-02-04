package com.revature.dao;

import com.revature.model.Admin;
import com.revature.model.User;

public interface AdminDao {
	
	// CRUD ONLY

	// CREATE
	public void insertUser(String fname, String lname, String uname, String pass);

	// READ
	public User selectUser(String uname);
	public Admin checkLogin(String uname, String pword);
	
	// UPDATE
	public void updateUserFName(String uname, String input);
	public void updateUserLName(String uname, String input);
	public void updateUserUName(String uname, String input);
	public void updateUserPass(String uname, String input);

	// DELETE
	public void deleteUser(String uname);


}
