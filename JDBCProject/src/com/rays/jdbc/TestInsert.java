package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into user values(1, 'Ram', 'Yadav', 'ram@gmail.com', 'pass123', '2001-02-02', 'Indore')");

		System.out.println("data inserted successfully = " + i);

	}

}
