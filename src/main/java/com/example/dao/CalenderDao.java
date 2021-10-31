package com.example.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.Calender;

public interface CalenderDao {
	void insert(Calender calender);
	void update(Calender calender);
	Calender selectByKey(int key);
	void deleteByKey(int key);
	List<Calender> selectByMember(int memberid);
	List<Calender> selectAll();
}
