package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.MemoDao;

public class MemoSearch {
	private MemoDao memoDao;
	private List<Memo> Allmemo;
	public MemoSearch(MemoDao memoDao) { this.memoDao = memoDao; }
	public List<Memo> searchImportant(int memberid)
	{
		Allmemo = memoDao.selectByMember(memberid);
		List<Memo> result = new ArrayList<Memo>();

		for(int i = 0; i < Allmemo.size(); i++)
		{
			if(Allmemo.get(i).getImportant() == true)
			{
				result.add(Allmemo.get(i));
			}
		}
		return result;
	}
	public List<Memo> searchWord(String word, int memberid)
	{
		Allmemo = memoDao.selectByMember(memberid);
		List<Memo> result = new ArrayList<Memo>();

		for(int i = 0; i < Allmemo.size(); i++)
		{
			if(Allmemo.get(i).getValue().contains(word))
			{
				result.add(Allmemo.get(i));
			}
		}
		return result;
	}
	public List<Memo> searchDate(String Period, int memberid)
	{
		String[] value = Period.split(",");
		Allmemo = memoDao.selectByMember(memberid);
		List<Memo> result = new ArrayList<Memo>();
		if (value[0].equals(Period))
		{
			try {
				LocalDate Date = LocalDate.parse(Period, DateTimeFormatter.ISO_DATE);
				for(int i = 0; i < Allmemo.size(); i++)
				{
					if(Allmemo.get(i).getDate().isEqual(Date))
					{
						result.add(Allmemo.get(i));
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
				for(int i = 0; i < Allmemo.size(); i++)
				{
					if(!Allmemo.get(i).getDate().isBefore(sDate) && !Allmemo.get(i).getDate().isAfter(eDate))
					{
						result.add(Allmemo.get(i));
					}
				}
			}catch(DateTimeParseException e) { System.out.println("잘못입력하셨습니다."); }
		}
		return result;
	}
}
