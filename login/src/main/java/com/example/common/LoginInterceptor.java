package com.example.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MemberDaoImpl;
import com.example.model.Member;

@Service
public class LoginInterceptor implements HandlerInterceptor
{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception 
	{		
		System.out.println("prehandelr");	
		
		if( request.getSession().getAttribute("admin") == null)
		{
			System.out.println("if");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
		
		else
		{
			System.out.println("else");
			response.sendRedirect("admin.do");
			return false;
		}		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
