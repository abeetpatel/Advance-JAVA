package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		Statement st = con.createStatement();
		
		int i = st.executeUpdate("insert into user values(12, 'ajeet', 'patel', 'demo@gmail.com', 'demo123', '2003-01-01', 'jabalpur')");
		
		System.out.println("data successfully updated = " + i);
		
	}

}
