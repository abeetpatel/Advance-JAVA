package abeet.patel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		Statement st = con.createStatement();
		
		ResultSet rs= st.executeQuery("select * from employee limit 0, 5");
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println(rs.getString(5));
			
		}
		
	}

}
