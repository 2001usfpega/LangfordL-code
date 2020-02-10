package com.project.service;

import java.util.List;

import com.project.dao.TicketDao;
import com.project.dao.TicketDaoImpl;
import com.project.model.Ticket;

public class TicketServiceImpl implements TicketService{
	
	private TicketDao ticketdao = new TicketDaoImpl();

	@Override
	public void getAllTickets() {
		
		List<Ticket> all = ticketdao.selectAllTickets();
		
		for(Ticket a:all) {
			System.out.println(a);
		}

	}
	
	
	
	

}
