package com.example.dao;

import com.example.model.Member;

public interface MemberDao 
{
	public int selectByUserIdPw(Member member);
}
