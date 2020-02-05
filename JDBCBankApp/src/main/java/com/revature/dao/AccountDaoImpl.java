package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Account;

public class AccountDaoImpl implements AccountDao{
	
	private static String dburl = System.getenv("TRAINING_DB_URL");
	private static String dbusername = System.getenv("BANK_DB_USERNAME");
	private static String dbpassword = System.getenv("TRAINING_DB_PASSWORD");
	
	@Override
	public void insertAccount(String uname, int amount) {
		
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "{ call insert_acct_null_id(?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, uname);//first question mark
			cs.setInt(2, amount);//second question mark
			cs.executeUpdate();	
			
			System.out.println("This account was successfully registered.");
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
	}
	
	@Override
	public Account selectAccount(String uname) {
		Account sacct = new Account();		
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "SELECT * FROM bankaccount WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				sacct.setAccountid(rs.getInt(1));
				sacct.setUsername(rs.getString(2));
				sacct.setBalance(rs.getInt(3));		
			}
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
		return sacct;
		
	}
	@Override
	public void depositAccount(String uname, int amount) {
		int balance = 0;
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "SELECT * FROM bankaccount WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				balance = (rs.getInt(3));		
			}
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		
		balance += amount;
		
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "UPDATE bankaccount SET balance = ? WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, balance);
			ps.setString(2, uname);	
			ps.executeUpdate();
			
			System.out.println("Deposit successful.");
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}		
	}
		
	
	@Override
	public void withdrawAccount(String uname, int amount) {
		int balance = 0;
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "SELECT * FROM bankaccount WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				balance = (rs.getInt(3));		
			}
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
		balance -= amount;
		
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "UPDATE bankaccount SET balance = ? WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, balance);
			ps.setString(2, uname);	
			ps.executeUpdate();
			
			System.out.println("Withdrawal successful.");
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}			
	}	
	
	@Override
	public void deleteAccount(String uname) {
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "DELETE FROM bankaccount WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.executeUpdate();
			
			System.out.println("This account was successfully deleted.");
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}
	}	
	

}
