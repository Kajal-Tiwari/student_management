package com.capgemini.service;
import com.capgemini.beans.Student;
public class StudentSchedular {
		private Student[] students=new Student[10];
		private int counterStudent;
		public String addStudentDetails(int stdRollNumber,String stdName,String[] stdCourses)
		{	
		students[counterStudent++]	=new Student(stdRollNumber, stdName, stdCourses);
		return "Student added Successfully";
		}
		public void showCountByCourseName(String stdCourse) {
			int countStudent=0;
			for(int i=0;i<counterStudent;i++) {
				String[] stdCourses=students[i].getstdCourses();
				for(int j=0;j<stdCourses.length;j++) {
					if(stdCourses[j].equals(stdCourse)) {
						countStudent++;
						break;
					}
				}
			}
			System.out.println("Number of students for this course: "+countStudent);
		}
		public void showAllStudents() {
			if(counterStudent==0)
				System.out.println("Sorry no student is added");
			else {
				System.out.println("Showing Data");
			for(int i=0;i<counterStudent;i++) {
				String[] stdCourses=students[i].getstdCourses();
				System.out.println("Student RollNumber is "+students[i].getstdRollNumber());
				System.out.println("Student name is "+students[i].getstdName());
				System.out.println("Name of subjects are: ");
				for(int x=0;x<stdCourses.length;x++) {
					System.out.println(stdCourses[x]);
				}
			}
			}
		}
		public void showStudentDetailByCourseName(String Course) {
			String Course1=Course;
			int count=0;
			String stdCourses[];
			for(int i=0;i<counterStudent;i++)
			{
				stdCourses=students[i].getstdCourses();
				for(int j=0;j<stdCourses.length;j++) {
					if(stdCourses[j].equals(Course1)) {
						System.out.println("Student RollNumber is "+students[i].getstdRollNumber());
						System.out.println("Student name is "+students[i].getstdName());
						System.out.println("Name of subjects are: ");
						for(int x=0;x<stdCourses.length;x++) {
							System.out.println(stdCourses[x]);
						}
						count++;
						break;
					}
				}
			}
		}
		public void showStudentDetailByRollNumber(int roll) {
			int roll1=roll;
			int count=0;
			String stdCourses[];
			for(int i=0;i<counterStudent;i++)
			{
					if(students[i].getstdRollNumber() == roll1) {
						stdCourses=students[i].getstdCourses();
						System.out.println("Student RollNumber is "+students[i].getstdRollNumber());
						System.out.println("Student name is "+students[i].getstdName());
						System.out.println("Name of subjects are: ");
						for(int x=0;x<stdCourses.length;x++) {
							System.out.println(stdCourses[x]);
						}
						count++;
						break;
					}
					else
					{
						System.out.println("no student of this roll number");
					}
			}
		}
}

