package com.project.dao;

public interface ManagerDao {
	
	public boolean loginUser(String username, String password);
	
	public void insertManager(String username, String password);
	
	public void selectManager(int manid);
	
	public void updateManager(int manid);
	
	public void deleteManager(int manid);

}
