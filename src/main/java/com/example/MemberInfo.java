package com.example;

import java.io.IOException;

import com.example.dao.MemberDao;

public class MemberInfo {
	private MemberDao mDao;

	public MemberInfo(MemberDao memberDao)
	{
		this.mDao = memberDao;
	}
	public Member login(String inputid, String inputpw)
	{
		Member loginuser;
		if((loginuser = mDao.selectByEmail(inputid)) != null)
		{
			if( inputpw.equals(loginuser.getPassword()))
			{
				System.out.println("로그인 성공");
				return loginuser;
			}	
			else
				System.out.println("로그인 실패");
		}
		else
			System.out.println("가입되어 있지 않숩니다.");
		
		return null;
	}
	public void changepw(Member member, String newpw) throws IOException
	{
			member.changePassword(newpw);
			mDao.update(member);
			System.out.println("비밀번호를 변경하였습니다.");
	}
	
	public void changeph(Member member, String phone) throws IOException
	{
		member.setPhone(phone);
		mDao.update(member);
	}
	
	public void changead(Member member, String address) throws IOException
	{
		member.setAddress(address);
		mDao.update(member);
	}
	
	public void deleteid(Member member) throws IOException
	{
		mDao.delete(member.getid());
	}

}
