 package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTranscation {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			// step 1
			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into user values(11, 'Ram', 'Yadav', 'ram@gmail.com', 'pass123', '2001-02-02', 'Indore')");

			i = stmt.executeUpdate(
					"insert into user values(12, 'Ram', 'Yadav', 'ram@gmail.com', 'pass123', '2001-02-02', 'Indore')");

			i = stmt.executeUpdate(
					"insert into user values(12, 'Ram', 'Yadav', 'ram@gmail.com', 'pass123', '2001-02-02', 'Indore')");

			// step 2
			conn.commit();

			System.out.println("data inserted successfully = " + i);

		} catch (Exception e) {

			// step 3
			conn.rollback();
			System.out.println(e.getMessage());
		}

	}

}
