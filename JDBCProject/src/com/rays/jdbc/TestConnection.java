package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// step 1 load mysql diriver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2 make connection to the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		// step 3 create statement
		Statement stmt = conn.createStatement();

		// step 4 get the record
		ResultSet rs = stmt.executeQuery("select * from employee limit 0, 5");

		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println(rs.getString(5));

		}

	}

}
