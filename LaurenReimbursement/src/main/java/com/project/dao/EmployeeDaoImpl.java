package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao{
	
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
	public boolean loginUser(String username, String password) {
		try(Connection connection = DriverManager.getConnection(dburl, dbusername, dbpassword)){
		    String sql = "SELECT * FROM employee WHERE username = ? AND pword = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, username);
	        statement.setString(2, password);
 
	        ResultSet rs = statement.executeQuery();
	        
	        String Uname = "";
	        String Pass = "";
	        
	        while (rs.next()) {
                Uname = rs.getString(2);
                Pass = rs.getString(3);
            } 
	        if (Pass.equals(password) & Uname.equals(username)) {
                return true;
            }
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }  
        return false;
    }

	
}
