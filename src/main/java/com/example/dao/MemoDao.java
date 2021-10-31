package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.Memo;

public interface MemoDao {
	void insert(Memo memo);
	void update(Memo memo);
	Memo selectByKey(int key);
	void deleteByKey(int key);
	List<Memo> selectByMember(int memberid);
	List<Memo> selectAll(int key);
}
