package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.model.Admin;

public class AdminDaoImpl implements AdminDao{
	
	private static String dburl = System.getenv("TRAINING_DB_URL");
	private static String dbusername = System.getenv("BANK_DB_USERNAME");
	private static String dbpassword = System.getenv("TRAINING_DB_PASSWORD");
	
	@Override
	public Admin checkLogin(String uname, String pword) {
		Admin admin = null;
		
		try(Connection connection = DriverManager.getConnection(dburl, dbusername, dbpassword)){
		    String sql = "SELECT * FROM adminb WHERE a_username = ? AND a_pword = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, uname);
	        statement.setString(2, pword);
 
	        ResultSet rs = statement.executeQuery();
 
	        
 
	        if (rs.next()) {
	            admin = new Admin();
	            admin.setAdminid(rs.getInt(1));
	            admin.setA_firstname(rs.getString(2));
	            admin.setA_lastname(rs.getString(3));
	            admin.setA_username(rs.getString(4));
	            admin.setA_pword(rs.getString(5));
	        }	        
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}  
		
		return admin;
	}
	@Override
	public void insertUser(String fname, String lname, String uname, String pass) {
		
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "{ call insert_user_null_id(?,?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, fname);//first question mark
			cs.setString(2, lname);//second question mark
			cs.setString(3, uname);
			cs.setString(4, pass);
			cs.executeUpdate();			
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
	}
	
	@Override
	public User selectUser(String uname) {
		User suser = new User();		
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "SELECT * FROM userb WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				suser.setUserid(rs.getInt(1));
				suser.setFirstname(rs.getString(2));
				suser.setLastname(rs.getString(3));
				suser.setUsername(rs.getString(4));
				suser.setPassword(rs.getString(5));				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
		return suser;
	}
	
	@Override
	public void updateUserFName(String uname, String input) {
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "UPDATE userb SET firstname = ? WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ps.setString(2, uname);	
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
	}
	
	@Override
	public void updateUserLName(String uname, String input) {
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "UPDATE userb SET lastname = ? WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ps.setString(2, uname);	
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
	}
	
	@Override
	public void updateUserUName(String uname, String input) {
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "UPDATE userb SET uaername = ? WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ps.setString(2, uname);	
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}			
	}
	
	@Override
	public void updateUserPass(String uname, String input) {
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "UPDATE userb SET pword = ? WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, input);
			ps.setString(2, uname);	
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
	}
	
	
	@Override
	public void deleteUser(String uname) {
		try(Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)){
			String sql = "DELETE FROM userb WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}	
	}	
	
	
	
}


