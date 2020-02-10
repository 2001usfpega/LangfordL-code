package com.project.servlets;

import javax.servlet.http.HttpServletRequest;

import com.project.controller.LoginController;
import com.project.controller.EmployeeController;
import com.project.controller.ManagerController;


public class RequestHelper {
	
public static String process(HttpServletRequest req) {
		
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/LaurenReimbursement/login.change":
			return LoginController.login(req);			
		case "/LaurenReimbursement/employeehome.change":
			return EmployeeController.employee(req);
		case "/LaurenReimbursement/managerhome.change":
			return ManagerController.admin(req);			
		default:
			System.out.println("in default case");
			return "resources/html/BadLogin.html";	
		}
	}

}
