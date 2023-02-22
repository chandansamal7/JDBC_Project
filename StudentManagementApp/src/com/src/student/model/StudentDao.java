package com.src.student.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDb(Student st) {

		boolean flag = false;

		try {

			// create connectionl
			Connection con = DbCon.craeteConnection();

			String query = "insert into students(sname,sphone,scity) values(?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			// set the values of parameter
			pst.setString(1, st.getStudentName());
			pst.setString(2, st.getStudentPhone());
			pst.setString(3, st.getStudentCity());

			// execute
			pst.executeUpdate();

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public static boolean deleteStudent(int id) {

		boolean flag = false;

		try {

			// create connectionl
			Connection con = DbCon.craeteConnection();

			String query = "delete from students where sid=?";

			PreparedStatement pst = con.prepareStatement(query);
			// set the values of parameter
			pst.setInt(1, id);

			// execute
			pst.executeUpdate();

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public static void displayStudent() {

		try {

			// create connectionl
			Connection con = DbCon.craeteConnection();

			String query = "select * from students";

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt("sid");
				String name = rs.getString("sname");
				String phone = rs.getString("sphone");
				String city = rs.getString("scity");

				System.out.println("Id: " + id);
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("City: " + city);

				System.out.println("+++++++++++++++++++");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
