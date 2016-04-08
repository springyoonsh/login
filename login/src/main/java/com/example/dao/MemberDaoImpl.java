package com.example.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource datasource)
	{
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}	
	
	@Override
	public int selectByUserIdPw(Member member) 
	{		
		String sql = " SELECT count(*) FROM member WHERE userId='admin' AND userPw='1234' 	";
		return jdbcTemplate.queryForInt(sql);		
	}
	
}
