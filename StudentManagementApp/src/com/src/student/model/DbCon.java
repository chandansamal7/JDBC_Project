package com.src.student.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {

	static Connection con;

	public static Connection craeteConnection() {

		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String user = "root";
			String password = "@Samal7377";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("conn built");

//			//load the driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/student_manage";
//			//create the connection
//			con = DriverManager.getConnection(url, "root", "@Samal7377");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
