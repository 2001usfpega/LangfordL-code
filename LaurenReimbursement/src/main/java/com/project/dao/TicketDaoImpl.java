package com.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Ticket;

public class TicketDaoImpl implements TicketDao{
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static String dburl = System.getenv("TRAINING_DB_URL");
	private static String dbusername = System.getenv("NEWBANKDB_USERNAME");
	private static String dbpassword = System.getenv("TRAINING_DB_PASSWORD");

	
	@Override
	public List<Ticket> selectAllTickets(){
		List<Ticket> expenses = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "SELECT * FROM expense";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				expenses.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10)));					
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}			
		return expenses;
	}

	
	@Override
	public void updateTicket(String firstname, String lastname, int type, double amount, String datesubmit,
			String notes, int userid) {

		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "INSERT INTO expense(userid, firstname, lastname, typeof, amount, datesubmitted, "
					+ " dateresolved, status, notes) VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setInt(4, type);
			ps.setDouble(5, amount);
			ps.setString(6, datesubmit);
			ps.setString(7, "TBD");
			ps.setString(8, "PENDING");
			ps.setString(9, notes);
			ps.executeUpdate();
			
			//conn.commit();
			System.out.println("This ticket has been successfully submitted.");
			
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}		
		
	}
//	@Override
//	public Ticket selecyByType(int ticketid) {
//		Ticket expense = new Ticket();		
//		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
//			String sql = "SELECT * FROM expense WHERE ticketid = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);	
//			ps.setInt(1, ticketid);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				expense.setTicketid(rs.getInt(1));
//				expense.setType(rs.getInt(2));
//				expense.setAmount(rs.getDouble(3));
//				expense.setDatesubmit(rs.getString(4));
//				expense.setDateresolve(rs.getString(5));
//				expense.setStatus(rs.getString(6));
//				expense.setNotes(rs.getString(7));
//				expense.setEmployeeid(rs.getInt(8));
//				
//			}
//		}
//		catch(SQLException e) {
//			e.printStackTrace();			
//		}
//		return expense;
//		
//	}
	

	

	

}
