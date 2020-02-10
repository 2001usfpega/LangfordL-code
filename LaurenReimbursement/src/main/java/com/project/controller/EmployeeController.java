package com.project.controller;

import javax.servlet.http.HttpServletRequest;

public class EmployeeController {
	
	public static String employee(HttpServletRequest req) {
		return "resources/html/EmployeeHome.html";
	}

}
