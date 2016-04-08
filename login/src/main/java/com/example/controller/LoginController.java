package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.MemberDaoImpl;
import com.example.model.Member;

@Controller
public class LoginController 
{	
	@Autowired
	MemberDaoImpl dao;
	
	@RequestMapping("login.do")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("login_db.do")
	public String login_db(HttpSession session, @RequestParam("userId") String userId, @RequestParam("userId") String userPw)
	{
		String returnUrl;
		Member member = new Member(userId,userPw);
		int rst = dao.selectByUserIdPw(member);
		System.out.println(rst);
		
		if(rst==1)
		{
			session.setAttribute("userId", "admin");
			returnUrl = "redirect:admin.do";
		}
		
		else
		{			
			returnUrl = "redirect:login.do";
		}	
			
		return returnUrl;
	}
	@RequestMapping("admin.do")
	public String admin()
	{
		return "admin";
	}
}
