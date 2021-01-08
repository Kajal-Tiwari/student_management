package com.capgemini.beans;

public class Student {
	private int stdRollNumber;
	private String stdName;
	private String[] stdCourses;
	public Student(int stdRollNumber2, String stdName2, String[] stdCourses2) {
		stdRollNumber=stdRollNumber2;
		stdName=stdName2;
		stdCourses=stdCourses2;
	}
	public int getstdRollNumber() {
		return stdRollNumber;
	}
	public void setStdRollNumber(int StdRollNumber) {
		stdRollNumber = StdRollNumber;
	}
	public String getstdName() {
		return stdName;
	}
	public void setStdName(String StdName) {
		stdName = StdName;
	}
	public String[] getstdCourses() {
		return stdCourses;
	}
	public void setStdCourses(String[] StdCourses) {
		stdCourses = StdCourses;
	}
	 

}
