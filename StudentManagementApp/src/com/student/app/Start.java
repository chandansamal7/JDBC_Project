package com.student.app;


import java.util.Scanner;

import com.src.student.model.Student;
import com.src.student.model.StudentDao;

public class Start {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Student Management APP");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) 
		{
			
			System.out.println("Press 1 to ADD Students");
			System.out.println("Press 2 to Delete Students");
			System.out.println("Press 3 to Display Students");
			System.out.println("Press 4 to Exit App");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			if(choice == 1) {
				
				//add Student
				
				System.out.println("Enter Student name: ");
				String name = scanner.nextLine();
				
				System.out.println("Enter Student phone no: ");
				String phone = scanner.nextLine();
				
				System.out.println("Enter Student city: ");
				String city = scanner.nextLine();
				
				//create Student obj to store student
				
				Student student = new Student(name, phone, city);
				//System.out.println(student);
				boolean ans = StudentDao.insertStudentToDb(student);
				
				if (ans) {
					System.out.println("Successfully added");
				}else {
					System.out.println("sorry!!!");
				}
				
				//System.out.println(student);
				
			}else if(choice == 2) {
				
				//delete student
				
				System.out.println("Enter student id to delete: ");
				
				int userId = scanner.nextInt();
				
				boolean ans = StudentDao.deleteStudent(userId);
				
				if (ans) {
					System.out.println("Successfully deleted");
				}else {
					System.out.println("sorry!!!");
				}
				
				
			}else if(choice == 3) {
				
				//display
				
				StudentDao.displayStudent();
				
			
				
			}else if(choice == 4) {
				
				//exit
				break;
			}else {
				
			}
		}
		
		System.out.println("Thank you for using my App!!!");

	}

}
