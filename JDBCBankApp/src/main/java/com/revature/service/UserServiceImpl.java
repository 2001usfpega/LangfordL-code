package com.revature.service;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	
	private UserDao newUser = new UserDaoImpl();
	Scanner scan = new Scanner(System.in);

	@Override
	public void createUser() {				
		
		System.out.println("Please enter your first name.");		
		String fname = scan.next();		
		System.out.println("Please enter your last name.");
		String lname = scan.next();		
		System.out.println("Please enter your new username.");
		String uname = scan.next();		
		System.out.println("Please enter your new password.");
		String pass = scan.next();
		
		newUser.insertUser(fname, lname, uname, pass);
				
	}
	
	@Override
	public void viewUser() {
		
		System.out.println("Please enter the username for the user you wish to view.");
		String uname = scan.next();
		System.out.println(newUser.selectUser(uname));
				
	}
	
	@Override
	public void changeUser() {
		
		System.out.println("Please enter the username for the user you wish to update.");
		String uname = scan.next();
		
		System.out.println("Which field would you like to update?");
		System.out.println("Enter 1 for firstname, 2 for lastname, 3 for username, or 4 for password.");
		int num = scan.nextInt();
		switch(num) {
		case 1:
			System.out.println("Please enter your new first name.");
			String input = scan.next();
			newUser.updateUserFName(uname, input);
			break;
		case 2:
			System.out.println("Please enter your new last name.");
			String input2 = scan.next();
			newUser.updateUserLName(uname, input2);
			break;
		case 3:
			System.out.println("Please enter your new username.");
			String input3 = scan.next();
			newUser.updateUserUName(uname, input3);
			break;
		case 4:
			System.out.println("Please enter your new password.");
			String input4 = scan.next();
			newUser.updateUserPass(uname, input4);
			break;
		default:
			System.out.println("Please return to the menu and try again.");
		}		
	}
	
	
	@Override
	public void removeUser() {
		
		System.out.println("Please enter the username for the user you wish to delete.");
		String uname = scan.next();
		newUser.deleteUser(uname);
		
	}	
	
	
	@Override 
	public void userLogin(){
		
		System.out.println("Please enter your username.");
		String uname = scan.next();
		System.out.println("Please enter your password.");
		String pword = scan.next();
		System.out.println(newUser.checkLogin(uname, pword));		
	}

}
