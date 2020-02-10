package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.project.dao.EmployeeDao;
import com.project.dao.EmployeeDaoImpl;
import com.project.dao.ManagerDao;
import com.project.dao.ManagerDaoImpl;


public class LoginController {
	
	final static Logger LOGGER = Logger.getLogger(LoginController.class); 
	
	public static String login(HttpServletRequest req) {
		
		LOGGER.setLevel(Level.INFO);
		
		if(!req.getMethod().equals("POST")) {
			return "resources/html/Login.html";
		}
		
		String username= req.getParameter("username"); 
		String password= req.getParameter("password");
		
		ManagerDao managerdao = new ManagerDaoImpl();
		EmployeeDao employeedao = new EmployeeDaoImpl();
		
		if(managerdao.loginUser(username, password) == true) {
			
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			LOGGER.info("A finance manager logged in.");
			return "managerhome.change";
		}
		if(employeedao.loginUser(username, password)) {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			LOGGER.info("An employee logged in.");
			return "employeehome.change";			
		}
		else {
			return "wrongcreds.change";
		}
	}	

}
