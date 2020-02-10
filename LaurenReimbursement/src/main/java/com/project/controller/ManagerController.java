package com.project.controller;

import javax.servlet.http.HttpServletRequest;

public class ManagerController {
	
	public static String admin(HttpServletRequest req) {
		return "resources/html/AdminHome.html";
	}

}
