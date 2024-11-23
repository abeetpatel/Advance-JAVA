package abeet.patel.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBCDataConnection {
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 1; i <= 100; i++) {
			
			testSearch();
			
			System.out.println("Connection = " + i);
			
		}
		
	}

	private static void testSearch() throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement st = conn.prepareStatement("select * from user where id = 1");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getDate(6));
			System.out.println("\t" + rs.getString(7));
			
		}
		
	}

}
