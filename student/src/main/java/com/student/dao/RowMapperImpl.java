package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.pojo.Student;

public class RowMapperImpl implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
     Student s = new Student();
     
     s.setId(rs.getInt(1));
     s.setFname(rs.getString(2));
     s.setLname(rs.getString(3));
     s.setCourse(rs.getString(4));
     

		
		return s;
	}
	
	

}
