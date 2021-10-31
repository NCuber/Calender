package com.example;

import java.time.LocalDate;

public class Memo {
	private int id;
	private LocalDate date;
	private String value;
	private int memberid;
	private boolean important;
	public Memo(int id, LocalDate date, String value, boolean important, int memberid)
	{
		this.date = date;
		this.value = value; 
		this.memberid = memberid;
		this.important = important;
	}
	
	void setId(int id) { this.id = id; }
	void setDate(LocalDate date) { this.date = date; }
	void setValue(String value) { this.value = value; }
	void setMemberid(int memberid) { this.memberid = memberid; } 
	void setImportant(boolean important) { this.important = important; }
	public int getId() { return id; }
	public LocalDate getDate() { return date; }
	public String getValue() { return value; }
	public int getMemberid() { return memberid; }
	public boolean getImportant() { return important; }
}
