package com.capgemini.ui;
import java.util.Scanner;
import com.capgemini.service.StudentSchedular;
public class Admin {
	private static Scanner sc=new Scanner(System.in);
	private static StudentSchedular studSch = new StudentSchedular();
	public static void main(String[] args) {
		showMenu();
	}
	private static void showMenu() {
		int choice;		
		while(true)
		{
			System.out.println("1.add student");
			System.out.println("2.show all students");
			System.out.println("3.show count by course name:");
			System.out.println("4.show student detail by course Name:");
			System.out.println("5.show student detail by Roll Number:");
			System.out.println("6.exit");
			System.out.println("Enter your choice");
			choice=sc.nextInt();			
			switch(choice)
			{
			case 1:addStudentDetails();
			       break;
			       
			 case 2:showAllStudents();
			        break;
			 case 3:showCountByCourseName();
			       break;
			 case 4:showStudentDetailByCourseName();
			       break;
			 case 5:showStudentDetailByRollNumber();
			       break;
			 case 6:System.exit(0);
			      break;
			 default:System.out.println("Sorry entered wrong choice");			   
			}			
		}		
	}
	private static void showStudentDetailByRollNumber() {
		System.out.println("Enter Roll Number:");
		int stdRollNumber=sc.nextInt();
		studSch.showStudentDetailByRollNumber(stdRollNumber);

	}
	
	private static void showStudentDetailByCourseName() {
		System.out.println("Enter Course Name:");
		String stdCourses=sc.next();
		studSch.showStudentDetailByCourseName(stdCourses);
	}
     private static void showCountByCourseName() {
	System.out.println("Enter Course Name:");
	String stdCourse=sc.next();
	studSch.showCountByCourseName(stdCourse);
    }
	private static void showAllStudents() {
		studSch.showAllStudents();		
	}

	private static void addStudentDetails() {
		System.out.println("Enter roll number");
		int stdRollNumber=sc.nextInt();
		
		System.out.println("Enter name");
		String stdName = sc.next();
		
		System.out.println("Enter the number of subjects:");
		int num=sc.nextInt();
		String[] stdCourses=new String[num];
		System.out.println("Enter the name of subjects:");
		for(int x=0;x<num;x++) {
			stdCourses[x]=sc.next();
		}
		System.out.println(studSch.addStudentDetails(stdRollNumber, stdName, stdCourses));		
	}
	
}
