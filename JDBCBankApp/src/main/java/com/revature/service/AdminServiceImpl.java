package com.revature.service;

import java.util.Scanner;

import com.revature.dao.AdminDao;
import com.revature.dao.AdminDaoImpl;



public class AdminServiceImpl implements AdminService{
	
	private AdminDao newAdmin = new AdminDaoImpl();
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void createUser() {
		System.out.println("Please enter the user's first name.");		
		String fname = scan.next();		
		System.out.println("Please enter the user's last name.");
		String lname = scan.next();		
		System.out.println("Please enter the user's new username.");
		String uname = scan.next();		
		System.out.println("Please enter the user's new password.");
		String pass = scan.next();
		
		newAdmin.insertUser(fname, lname, uname, pass);
				
		
	}
	@Override
	public void viewUser() {
		
		System.out.println("Please enter the username for the user you wish to view.");
		String uname = scan.next();
		System.out.println(newAdmin.selectUser(uname));
		
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
			newAdmin.updateUserFName(uname, input);
			break;
		case 2:
			System.out.println("Please enter your new last name.");
			String input2 = scan.next();
			newAdmin.updateUserLName(uname, input2);
			break;
		case 3:
			System.out.println("Please enter your new username.");
			String input3 = scan.next();
			newAdmin.updateUserUName(uname, input3);
			break;
		case 4:
			System.out.println("Please enter your new password.");
			String input4 = scan.next();
			newAdmin.updateUserPass(uname, input4);
			break;
		default:
			System.out.println("Please return to the menu and try again.");
		}		
		
	}
	@Override
	public void removeUser() {

		System.out.println("Please enter the username for the user you wish to delete.");
		String uname = scan.next();
		newAdmin.deleteUser(uname);
		
	}
	@Override
	public int adminLogin() {

		System.out.println("Please enter your username.");
		String uname = scan.next();
		System.out.println("Please enter your password.");
		String pword = scan.next();
		if(newAdmin.checkLogin(uname, pword) == true) {
			return 1;
		}
		return 0;		
	}

}
