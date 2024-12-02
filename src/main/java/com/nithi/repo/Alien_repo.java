package com.nithi.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nithi.model.Alien;
@Repository
public class Alien_repo {
	
	private JdbcTemplate jdbctemp;
	public JdbcTemplate getJdbctemp() {
		return jdbctemp;
	}
	@Autowired
	public void setJdbctemp(JdbcTemplate jdbctemp) {
		this.jdbctemp = jdbctemp;
	}
	public void save( Alien alien)
	{ 
		String querry= "insert into Alien(id,name,tech) values(?,?,?)";
		int rows=jdbctemp.update(querry,alien.getId() ,alien.getName(),alien.getTech());
		System.out.println("added"+rows+"rows");
	}
	public List<Alien> printall()
	{
		String fetchquery="select*from Alien";
		RowMapper<Alien> mapper=new RowMapper<Alien>()
				{
			@Override
			public Alien mapRow(ResultSet rs,int roeno )throws SQLException
			{
				Alien a=new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTech(rs.getString(3));
				
				return a;
			}
				};
				List<Alien> alien=jdbctemp.query(fetchquery, mapper);
		return alien;
	}

}
