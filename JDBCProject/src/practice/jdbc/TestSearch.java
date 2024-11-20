package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from user");
		
		while(rs.next()) {
			
			System.out.print(rs.getInt(1));
			System.out.print("\t"+ rs.getString(2));
			System.out.print("\t"+ rs.getString(3));
			System.out.print("\t"+ rs.getString(4));
			System.out.print("\t"+ rs.getString(5));
			System.out.print("\t"+ rs.getDate(6));
			System.out.println("\t"+ rs.getString(7));
			
		}
		
	}

}
