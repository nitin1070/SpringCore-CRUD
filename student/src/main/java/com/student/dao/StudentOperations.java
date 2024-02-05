package com.student.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.student.pojo.Student;

import com.student.dao.RowMapperImpl;

public class StudentOperations implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addStudent(Student student) {

		String query = "insert into test(id,fname,lname,course) values(?,?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getFname(), student.getLname(),
				student.getCourse());

		return result;

	}

	@Override
	public int deleteStudent(int id) {
		String query = "delete from test WHERE id=?";
		int result = this.jdbcTemplate.update(query, id);
		return result;
	}

	@Override
	public int updateStudent(Student student) {
		String query = "update test set fname=?,lname=?,course=? WHERE id=?";
		int result = this.jdbcTemplate.update(query,student.getFname(),student.getLname(),student.getCourse(),student.getId());
		return result;
	}

	@Override
	public List<Student> showAllStudent() {
		String query = "SELECT * FROM test";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());

		return students;

	}

}
