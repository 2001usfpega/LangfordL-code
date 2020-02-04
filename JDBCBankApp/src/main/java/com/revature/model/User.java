package com.revature.model;

public class User {
	
	private int userid;
	private String firstname;
	private String lastname;
	private String username;
	private String pword;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userid, String firstname, String lastname, String username, String pword) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.pword = pword;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return pword;
	}

	public void setPassword(String password) {
		this.pword = password;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + pword + "]";
	}
	
	
}
