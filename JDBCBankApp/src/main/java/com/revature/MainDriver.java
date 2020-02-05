package com.revature;

import java.util.Scanner;

import com.revature.service.AccountService;
import com.revature.service.AccountServiceImpl;
import com.revature.service.AdminService;
import com.revature.service.AdminServiceImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;



public class MainDriver {
	
	public static Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the bank! How may we help you today?");
		System.out.println("If you are an unregistered user, select 1 to register.");
		System.out.println("If you are a returning customer, select 2 to view menu options.");
		System.out.println("Select 3 if you are an Admin.");
		
		int in = scan.nextInt();
		switch(in) {
		case 1:
			UserService User1 = new UserServiceImpl();
			System.out.println("Thank you for choosing to be a customer of ours.");
			User1.createUser();
			break;
		case 2:
			AccountService Account1 = new AccountServiceImpl();
			UserService User2 = new UserServiceImpl();
			System.out.println("Please log in using your user username and password.");
			if(User2.userLogin() == 0) {
				System.out.println("The username or password entered is incorrect. Please start over to try again.");
				break;
			}else {
				System.out.println("Welcome back!");
			}
			
			int in2 = 0;
			do {
			System.out.println("---------------------------");			
			System.out.println("Enter 1 if you would like to create a new account.");
			System.out.println("Enter 2 if you would like to view an existing account.");
			System.out.println("Enter 3 if you would like to make a withdrawal from an existing account.");
			System.out.println("Enter 4 if you would like to make a deposit into an existing account.");
			System.out.println("Enter 5 if you would like to delete an empty account.");
			System.out.println("Enter 6 to logout and exit.");
			in2 = scan.nextInt();
			switch(in2) {
			case 1:
				Account1.createAccount();
				break;
			case 2:
				Account1.viewAccount();
				break;
			case 3:
				Account1.withdraw();
				break;
			case 4:
				Account1.deposit();
				break;
			case 5:
				Account1.removeAccount();
				break;
			case 6:
				System.out.println("Thank you and have a good day.");
				break;
			default:
				System.out.println("Please return to the menu and choose a valid option.");				
			}
			}while(in2 != 6);
			break;
		case 3:
			AdminService Admin1 = new AdminServiceImpl();
			System.out.println("Please log in using your user username and password.");
			if(Admin1.adminLogin() == 0) {
				System.out.println("The username or password entered is incorrect. Please start over to try again.");
				break;
			}else {
				System.out.println("Welcome back!");
			}
			int in3 = 0;
			
			do{
			System.out.println("---------------------------");			
			System.out.println("Enter 1 if you would like to create a new user.");
			System.out.println("Enter 2 if you would like to view an existing user.");
			System.out.println("Enter 3 if you would like to update an existing user.");
			System.out.println("Enter 4 if you would like to delete a user.");
			System.out.println("Enter 5 to logout and exit");
			in3 = scan.nextInt();
			switch(in3) {
			case 1:
				Admin1.createUser();
				break;
			case 2:
				Admin1.viewUser();
				break;
			case 3:
				Admin1.changeUser();
				break;
			case 4:
				Admin1.removeUser();
				break;
			case 5:
				System.out.println("See you next time!");
				break;
			default:
				System.out.println("Please return to the menu and choose a valid option.");				
			}
			}while(in3 != 5);
			break;
		default:
			System.out.println("Please return to the menu and choose a valid option.");
		}
		
	}

}
