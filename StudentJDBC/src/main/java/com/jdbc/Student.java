package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			String addStudent = "INSERT INTO STUDENT VALUES (?, ?, ?)";
			String updateStudent = "UPDATE STUDENT SET MARKS = ? WHERE ID = ?";
			String deleteStudent = "DELETE FROM STUDENT WHERE ID = ?";
			String showAll = "SELECT * FROM STUDENT";
			boolean flag = true;
			do {
				System.out.println("Enter your choice : ");
				System.out.println("1. Add student");
				System.out.println("2. Update student");
				System.out.println("3. Delete student");
				System.out.println("4. View all student");
				System.out.println("5. Any other to exit");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter student details : ");
					System.out.println("Enter the id : ");
					int id1 = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the name : ");
					String name1 = sc.nextLine();
					System.out.println("Enter the marks : ");
					double marks1 = sc.nextDouble();
					PreparedStatement ps1 =  conn.prepareStatement(addStudent);
					ps1.setInt(1, id1);
					ps1.setString(2, name1);
					ps1.setDouble(3, marks1);
					int res1 = ps1.executeUpdate();
					if(res1 != 0) {
						System.out.println("Student inserted successfully");
					}else {
						System.out.println("Error occured");
					}
					break;
				case 2:
					System.out.println("Enter the id : ");
					int id2 = sc.nextInt();
					System.out.println("Enter the marks : ");
					double marks2 = sc.nextDouble();
					PreparedStatement ps2 =  conn.prepareStatement(updateStudent);
					ps2.setDouble(1, marks2);
					ps2.setInt(2, id2);
					int res2 = ps2.executeUpdate();
					if(res2 != 0) {
						System.out.println("Student updated successfully");
					}else {
						System.out.println("Error occured");
					}
					break;
				case 3:
					System.out.println("Enter the id : ");
					int id3 = sc.nextInt();
					PreparedStatement ps3 =  conn.prepareStatement(deleteStudent);
					ps3.setInt(1, id3);
					int res3 = ps3.executeUpdate();
					if(res3 != 0) {
						System.out.println("Student deleted successfully");
					}else {
						System.out.println("Error occured");
					}
					break;
				case 4:
					System.out.println("All student");
					PreparedStatement ps4 =  conn.prepareStatement(showAll);
					ResultSet rs = ps4.executeQuery();
					if(!rs.next()) {
						System.out.println("Error occured");
					}else {
						System.out.println(rs.getString(2)+", "+rs.getDouble(3));
						while(rs.next()) {
							System.out.println(rs.getString(2)+", "+rs.getDouble(3));
						}
					}
					break;
				default:
					flag = false;
					break;
				}
			}while(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
