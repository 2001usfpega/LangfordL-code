package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.project.dao.TicketDao;
import com.project.dao.TicketDaoImpl;

@SuppressWarnings("serial")
public class EmployeeServlet extends HttpServlet {
	
	final static Logger LOGGER = Logger.getLogger(EmployeeServlet.class); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOGGER.setLevel(Level.INFO);
		
		TicketDao ticket = new TicketDaoImpl();
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		int type = Integer.parseInt(request.getParameter("type"));
		double amount = Double.parseDouble(request.getParameter("Amount"));
		String date = request.getParameter("Date");
		String notes = request.getParameter("Description");
		
		ticket.updateTicket(firstname, lastname, type, amount, date, notes, userid);
		
		LOGGER.info("A new expense ticket has been added.");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", userid);
		session.setAttribute("fname", firstname);
		session.setAttribute("lname", lastname);
		session.setAttribute("typeof", type);
		session.setAttribute("amountof", amount);
		session.setAttribute("datesub", date);
		session.setAttribute("descrip", notes);
		
		PrintWriter out = response.getWriter();
		out.println( "<html>");
		
		out.println("<title> Submission Confirmation </title>");
		
		out.println("<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
				"href=\"/LaurenReimbursement/resources/css/employeestyle.css\" />");
			
		out.println("<body>");
		
		out.println("<h2>Your ticket has been submitted.</h2>");
		
		out.println("</body></html>");				

	}

}
