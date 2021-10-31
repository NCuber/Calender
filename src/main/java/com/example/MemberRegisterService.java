package com.example;

import java.time.LocalDate;

import com.example.dao.MemberDao;

public class MemberRegisterService {
	private MemberDao memberDao;

	public void setmemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	public int regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member!= null)
		{
			System.out.println("Already Exist");
			return 3;
		}
		if((req.getEmail().contains("@") && req.getEmail().substring(req.getEmail().indexOf("@")+1).contains(".")) == false)
		{
			System.out.println("이메일 양식에 맞지 않습니다. example@exam.com");
			return 1;
		}
		if (req.getPassword().equals(req.getConfirmPassword()))
		{
			Member newMember = new Member(0, req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), req.getAddress(), java.sql.Date.valueOf(LocalDate.now()));			
			memberDao.insert(newMember);
			System.out.println("계정이 등록되었습니다. 로그인이 가능합니다.");
			return 0;
		}
		else
		{
			System.out.println("비밀번호가 동일하지 않습니다. 다시 입력해주세요.");
			return 2;
		}
	}
}
