package com.project.dao;

import java.util.List;

import com.project.model.Ticket;

public interface TicketDao {
	
	
	//READ
	//public Ticket selecyByType(int ticketid);
	public List<Ticket> selectAllTickets();
	
	//UPDATE
	public void updateTicket(String firstname, String lastname, int type, double amount, String datesubmit,
			String notes, int userid);
	
	

}
