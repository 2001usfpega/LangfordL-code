package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.TicketDao;
import com.project.dao.TicketDaoImpl;
import com.project.model.Ticket;

@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TicketDao ticketdao = new TicketDaoImpl();
		List<Ticket> ticket = ticketdao.selectAllTickets();
		
		PrintWriter out = response.getWriter();
		out.println( "<html>");
		
		out.println("<title> All Reimbursement Requests </title>");
		
		out.println("<link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
				"href=\"/LaurenReimbursement/resources/css/expensestyle.css\" />");
			
		out.println("<body>");
		
		out.println("<h2>Reimbursement Requests</h2>");
		
		out.println("<table>");
		
		out.println("<tr> <th>User Id</th> <th>First Name</th> <th>Last Name</th> "
				+ "<th>Type</th> <th>Amount</th> <th>Date Submitted</th> <th>Date Resolved</th> "
				+ "<th>Status</th> <th>Description</th> <th>Ticket Id</th> </tr>");
		
		for(Ticket t:ticket) {
			out.println("<tr> <td>" + t.getUserid() + "</td>"
					+ "<td>" + t.getFirstname() + "</td>"
					+ "<td>" + t.getLastname() + "</td>"
					+ "<td>" + t.getType() + "</td>"
					+ "<td>" + t.getAmount() + "</td>"
					+ "<td>" + t.getDatesubmit() + "</td>"
					+ "<td>" + t.getDateresolve() + "</td>"
					+ "<td>" + t.getStatus() + "</td>"
					+ "<td>" + t.getNotes() + "</td>"
					+ "<td>" + t.getTicketid() + "</td> </tr>");			
		}
		
		
		out.println("</table>"); 
		
		
		out.println( "</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
