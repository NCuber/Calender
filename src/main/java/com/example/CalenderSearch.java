package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.CalenderDao;

public class CalenderSearch {
	private CalenderDao cDao;
	private List<Calender> AllCal;
	public List<Calender> searchComplete(int memberid)
	{
		AllCal = cDao.selectByMember(memberid);
		List<Calender> result = new ArrayList<Calender>();

		for(int i = 0; i < AllCal.size(); i++)
		{
			if(AllCal.get(i).getComplete() == false)
			{
				result.add(AllCal.get(i));
			}
		}
		return result;
	}
	public CalenderSearch(CalenderDao cDao) { this.cDao = cDao; }
	public List<Calender> searchWord(String word, int memberid)
	{
		System.out.println(word);
		AllCal = cDao.selectByMember(memberid);
		List<Calender> list = new ArrayList<Calender>();

		for(int i = 0; i < AllCal.size(); i++)
		{
			if(AllCal.get(i).getValue().contains(word))
			{
				list.add(AllCal.get(i));	
				System.out.println(AllCal.get(i));
			}
		}
		return list;
	}
	
	public List<Calender> searchDate(String Period, int memberid)
	{
		String[] value = Period.split(",");
		AllCal = cDao.selectByMember(memberid);
		List<Calender> list = new ArrayList<Calender>();
		if(value[0].equals(Period))
		{
			try {
				LocalDate Date = LocalDate.parse(Period, DateTimeFormatter.ISO_DATE);
				for(int i = 0; i < AllCal.size(); i++)
				{
					if(!Date.isBefore(AllCal.get(i).getSdate()) && !Date.isAfter(AllCal.get(i).getEdate()))
					{
						list.add(AllCal.get(i));
						
					}
				}

			}catch(DateTimeParseException e) { System.out.println("잘못입력하셨습니다."); }
		}
		else
		{
			try
			{
				LocalDate sDate = LocalDate.parse(value[0], DateTimeFormatter.ISO_DATE);
				LocalDate eDate = LocalDate.parse(value[1].trim(), DateTimeFormatter.ISO_DATE);
				for(int i = 0; i < AllCal.size(); i++)
				{
					if(!sDate.isAfter(AllCal.get(i).getEdate()) && !eDate.isBefore(AllCal.get(i).getSdate()))
					{
						list.add(AllCal.get(i));

					}
				}
			}catch(DateTimeParseException e) { System.out.println("잘못입력하셨습니다."); }
		}
		return list;
	}
	

	
}
