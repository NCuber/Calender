package com.example;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.example.dao.CalenderDao;

public class CalenderInfo {
	private CalenderDao cDao;


	
	public CalenderInfo(CalenderDao calenderDao)
	{
		this.cDao = calenderDao;

	}
	

	public List<Calender> printlist(int memberid)
	{
		List<Calender> AllCal = cDao.selectByMember(memberid);
		return AllCal;
	}
	
	public Calender print(int key) throws IOException
	{
		Calender temp;
		temp = cDao.selectByKey(key);
		return temp;

	}
	public void insert(LocalDate sDate, LocalDate eDate, String value, int memberid) throws IOException
	{
		Calender newCal = new Calender(0, sDate, eDate, value, false, memberid);
		cDao.insert(newCal);
		
	}
	public void isComplete(Calender cal, boolean value) throws IOException
	{
		cal.setComplete(value);
		cDao.update(cal);

	}
	public void delete(int key) throws IOException
	{
		cDao.deleteByKey(key);

	}
	public void update(String value, LocalDate sdate, LocalDate edate, int key) throws IOException
	{
		Calender temp = cDao.selectByKey(key);
		temp.setValue(value);
		temp.setSdate(sdate);
		temp.setEdate(edate);
		cDao.update(temp);
	}

}
