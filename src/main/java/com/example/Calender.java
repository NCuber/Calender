package com.example;

import java.time.LocalDate;


public class Calender {
	private int id;
	private LocalDate sdate, edate;
	private String value;
	private boolean complete;
	private int memberid;
	
	public Calender(int id, LocalDate sdate, LocalDate edate, String value, boolean complete, int memberid)
	{
		this.sdate = sdate;
		this.edate = edate;
		this.value = value;
		this.complete = complete;
		this.memberid = memberid;
	}
	
	void setId(int id) { this.id = id; }
	void setComplete(boolean complete) { this.complete = complete; }
	void setValue(String value) { this.value = value; }
	void setSdate(LocalDate sdate){ this.sdate = sdate; }
	void setEdate(LocalDate edate){ this.edate = edate; }
	void setMemberid(int memberid) { this.memberid = memberid; } 
	public int getId() { return id; }
	public LocalDate getSdate() { return sdate; }
	public LocalDate getEdate() { return edate; }
	public String getValue() { return value; }
	public boolean getComplete() { return complete; }
	public int getMemberid() { return memberid; }
}
