package abeet.patel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		Statement st = con.createStatement();
		
		int i = st.executeUpdate("delete from user where id = 11");
		
		System.out.println("data deleted successfully = " + i);
		
	}

}
