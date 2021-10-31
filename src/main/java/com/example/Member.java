package com.example;

import java.sql.Date;

public class Member {
	private int id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String address;
	private Date regdate;
	
	public Member(int id, String email, String password, String name, String phone, String address, Date regdate)
	{
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.regdate = regdate;
	}
	
	void setId(int id) { this.id = id;}
	void setEmail(String email) { this.email = email; }
	void setpassword(String password) { this.password = password;}
	void setName(String name) { this.name = name; }
	void setPhone(String phone) { this.phone = phone; }
	void setAddress(String address) { this.address = address; }
	void setRegdate(Date regdate) { this.regdate = regdate;}
	public int getid() { return id;}
	public String getEmail() { return email;}
	public String getPassword() { return password;}
	public String getName() { return name;}
	public String getPhone() { return phone;}
	public String getAddress() { return address;}
	public Date getRegdate() { return regdate;}
	
	public void changePassword(String newPassword)
	{
		this.password = newPassword; 
	}
}
