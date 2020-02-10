package com.project.main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.project.dao.EmployeeDao;
import com.project.dao.EmployeeDaoImpl;
import com.project.dao.ManagerDao;
import com.project.dao.ManagerDaoImpl;
import com.project.dao.TicketDao;
import com.project.dao.TicketDaoImpl;
import com.project.model.Ticket;
import com.project.service.TicketService;
import com.project.service.TicketServiceImpl;

public class MainDriver {
	
	final static Logger LOGGER = Logger.getLogger(MainDriver.class);
	
	static TicketDao test = new TicketDaoImpl();
	static TicketService test2 = new TicketServiceImpl();
	static ManagerDao test3 = new ManagerDaoImpl();
	static EmployeeDao test4 = new EmployeeDaoImpl();

	public static void main(String[] args) {
		
		LOGGER.setLevel(Level.INFO);
		
		//test.updateTicket("erin", "langford", 1, 25.50, "02-08-2020", "gas + food", 52);
		
		System.out.println(test.selectAllTickets());
		
		//test2.getAllTickets();
		
		//Ticket expense = new Ticket(0, 1, 20.0, "01-15-20", "01-20-20", "approved", "none",0);
		//test.updateTicket(expense);
		
		//System.out.println(test3.loginUser("lel28", "hiya"));
		
		//System.out.println(test4.loginUser("lel", "28"));


	}

}
