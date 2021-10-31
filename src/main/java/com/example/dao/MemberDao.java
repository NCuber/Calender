package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.Member;

public interface MemberDao {
	void insert(Member member);
	void update(Member member);
	void delete(int id);
	Member selectByEmail(String email);
	List<Member> selectAll();

}
