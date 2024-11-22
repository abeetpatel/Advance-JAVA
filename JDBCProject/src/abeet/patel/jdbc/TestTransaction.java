package abeet.patel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestTransaction {
	
	public static void main(String[] args) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("abeet.patel.bundle.system");
		
		Connection conn = null;
		
		try {
			
			Class.forName(rb.getString("driver"));
			
			conn = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
			
			conn.setAutoCommit(false);
			
			Statement st = conn.createStatement();
			
			int i = st.executeUpdate("insert into user values(11, 'rahul', 'patel', 'rahul@gmail.com', 'rahul123', '2001-01-01', 'jabalpur')");
			
			i = st.executeUpdate("insert into user values(12, 'rahul', 'patel', 'rahul@gmail.com', 'rahul123', '2001-01-01', 'jabalpur')");
			
			i = st.executeUpdate("insert into user values(12, 'rahul', 'patel', 'rahul@gmail.com', 'rahul123', '2001-01-01', 'jabalpur')");
			
			conn.commit();
			
			System.out.println("data inserted successfully = " + i);
			
		} catch (Exception e) {
			
			conn.rollback();
			
			System.out.println(e.getMessage());
			
		}
		
		
		
	}

}
