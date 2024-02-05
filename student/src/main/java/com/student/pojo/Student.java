package com.student.pojo;

public class Student {
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", course=" + course + "]";
	}
	public Student(int id, String fname, String lname, String course) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.course = course;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	private int id;
	private String fname;
	private String lname;
	private String course;
	

}
