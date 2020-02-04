package com.revature.model;

public class Admin {
	
	private int adminid;
	private String a_firstname;
	private String a_lastname;
	private String a_username;
	private String a_pword;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminid, String a_firstname, String a_lastname, String a_username, String a_pword) {
		super();
		this.adminid = adminid;
		this.a_firstname = a_firstname;
		this.a_lastname = a_lastname;
		this.a_username = a_username;
		this.a_pword = a_pword;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getA_firstname() {
		return a_firstname;
	}

	public void setA_firstname(String a_firstname) {
		this.a_firstname = a_firstname;
	}

	public String getA_lastname() {
		return a_lastname;
	}

	public void setA_lastname(String a_lastname) {
		this.a_lastname = a_lastname;
	}

	public String getA_username() {
		return a_username;
	}

	public void setA_username(String a_username) {
		this.a_username = a_username;
	}

	public String getA_pword() {
		return a_pword;
	}

	public void setA_pword(String a_pword) {
		this.a_pword = a_pword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a_firstname == null) ? 0 : a_firstname.hashCode());
		result = prime * result + ((a_lastname == null) ? 0 : a_lastname.hashCode());
		result = prime * result + ((a_pword == null) ? 0 : a_pword.hashCode());
		result = prime * result + ((a_username == null) ? 0 : a_username.hashCode());
		result = prime * result + adminid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (a_firstname == null) {
			if (other.a_firstname != null)
				return false;
		} else if (!a_firstname.equals(other.a_firstname))
			return false;
		if (a_lastname == null) {
			if (other.a_lastname != null)
				return false;
		} else if (!a_lastname.equals(other.a_lastname))
			return false;
		if (a_pword == null) {
			if (other.a_pword != null)
				return false;
		} else if (!a_pword.equals(other.a_pword))
			return false;
		if (a_username == null) {
			if (other.a_username != null)
				return false;
		} else if (!a_username.equals(other.a_username))
			return false;
		if (adminid != other.adminid)
			return false;
		return true;
	}
	
}
