package com.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.project.dao.EmployeeDao;
import com.project.dao.EmployeeDaoImpl;
import com.project.dao.ManagerDao;
import com.project.dao.ManagerDaoImpl;

class CheckLoginJUnit {
	
	static ManagerDao test3 = new ManagerDaoImpl();
	static EmployeeDao test4 = new EmployeeDaoImpl();

	@Test
	void testManager() {
		boolean actualOutput = test3.loginUser("lel28", "hiya");
		boolean expectedOutput = true;
		assertEquals(actualOutput,expectedOutput);
	}
	
	@Test
	void testEmployee() {
		boolean actualOutput = test4.loginUser("lel", "28");
		boolean expectedOutput = true;
		assertEquals(actualOutput,expectedOutput);		
	}

}
