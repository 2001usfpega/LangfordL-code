package com.project.model;

public class Ticket {

	private int userid;
	private String firstname;
	private String lastname;
	private int type;
	private double amount;
	private String datesubmit;
	private String dateresolve;
	private String status;
	private String notes;
	private int ticketid;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(int userid, String firstname, String lastname, int type, double amount, String datesubmit,
			String dateresolve, String status, String notes, int ticketid) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.amount = amount;
		this.datesubmit = datesubmit;
		this.dateresolve = dateresolve;
		this.status = status;
		this.notes = notes;
		this.ticketid = ticketid;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDatesubmit() {
		return datesubmit;
	}

	public void setDatesubmit(String datesubmit) {
		this.datesubmit = datesubmit;
	}

	public String getDateresolve() {
		return dateresolve;
	}

	public void setDateresolve(String dateresolve) {
		this.dateresolve = dateresolve;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	@Override
	public String toString() {
		return "Ticket [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", type=" + type
				+ ", amount=" + amount + ", datesubmit=" + datesubmit + ", dateresolve=" + dateresolve + ", status="
				+ status + ", notes=" + notes + ", ticketid=" + ticketid + "]";
	}

}

