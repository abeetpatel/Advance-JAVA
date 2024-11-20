package abeet.patel.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {
	
	public void insert(UserBean been) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		PreparedStatement st = con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		
		st.setInt(1, been.getId());
		st.setString(2, been.getFirstName());
		st.setString(3, been.getLastName());
		st.setString(4, been.getLoginId());
		st.setString(5, been.getPassword());
		st.setDate(6, new java.sql.Date(been.getDob().getTime()));
		st.setString(7, been.getAddress());
		
		int i = st.executeUpdate();
		
		System.out.println("data inserted succesfully = " + i);
		
	}
	
	public void update(UserBean been) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		PreparedStatement st = con.prepareStatement("update user set firstName = ?,lastName =?,loginId = ?,password = ?,dob = ?,address = ? where id = ?");
		
		st.setString(1, been.getFirstName());
		st.setString(2, been.getLastName());
		st.setString(3, been.getLoginId());
		st.setString(4, been.getPassword());
		st.setDate(5, new java.sql.Date(been.getDob().getTime()));
		st.setString(6, been.getAddress());
		st.setInt(7, been.getId());
		
		int i = st.executeUpdate();
		
		System.out.println("data updated successfully = " + i);
		
	}
	
	public void delete(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		PreparedStatement st = conn.prepareStatement("delete from user where id = ?");
		
		st.setInt(1, id);
		
		int i = st.executeUpdate();
		
		System.out.println("data deleted successfully = " + i);
		
	}
	
	public UserBean finedById(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		PreparedStatement st = conn.prepareStatement("select * from user where id = ?");
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		UserBean been = null;
				
		while(rs.next()) {
			
			been = new UserBean();
			
			been.setId(rs.getInt(1));
			been.setFirstName(rs.getString(2));
			been.setLastName(rs.getString(3));
			been.setLoginId(rs.getString(4));
			been.setPassword(rs.getString(5));
			been.setDob(rs.getDate(6));
			been.setAddress(rs.getString(7));
			
		}
		
		return been;
		
	}
	
	public UserBean authentication(String loginId, String password) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		PreparedStatement st = conn.prepareStatement("select * from user where loginId = ? and password = ?");
		
		st.setString(1, loginId);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		UserBean been = null;
		
		while(rs.next()) {
			
			been = new UserBean();
			
			been.setId(rs.getInt(1));
			been.setFirstName(rs.getString(2));
			been.setLastName(rs.getString(3));
			been.setLoginId(rs.getString(4));
			been.setPassword(rs.getString(5));
			been.setDob(rs.getDate(6));
			been.setAddress(rs.getString(7));
			
		}
		
		return been;
		
	}

}
