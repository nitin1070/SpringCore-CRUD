package com.student.dao;

import java.util.List;

import com.student.pojo.Student;

public interface StudentDao {
	
	public int addStudent(Student student);
	public int deleteStudent(int id);
	public int updateStudent(Student student);
	public List<Student> showAllStudent();

}
