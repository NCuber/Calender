package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.dao.MemoDao;

public class MemoInfo {
	private MemoDao memoDao;

	
	public MemoInfo(MemoDao memoDao)
	{
		this.memoDao = memoDao;
	}

	public List<Memo> printlist(int memberid)
	{
		return memoDao.selectByMember(memberid);
	}
	
	public Memo print(int key) throws IOException
	{
		return memoDao.selectByKey(key);

	}
	public void update(String value, boolean important, int key) throws IOException
	{
		Memo temp = memoDao.selectByKey(key);
		System.out.println(value);
		
		temp.setValue(value);
		temp.setImportant(important);
		memoDao.update(temp);
	}
	public void insert(String value, boolean important, int memberid) throws IOException
	{
		Memo newMemo = new Memo(0, LocalDate.now(), value, important, memberid);
		memoDao.insert(newMemo);

	}
	
	public void delete(int key) throws IOException
	{
		memoDao.deleteByKey(key);
		
	}
	
	public void exit() throws IOException
	{
		
	}
}
