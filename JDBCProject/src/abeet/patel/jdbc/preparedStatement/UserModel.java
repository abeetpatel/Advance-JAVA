package abeet.patel.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserModel {
	
	public int nextPk() throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");
		
		int pk = 0;
		
		Class.forName(rb.getString("driver"));
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		PreparedStatement st = conn.prepareStatement("select max(id) from user");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			pk = rs.getInt(1);
			
			System.out.println("max id = " +pk);
			
		}
		
		return pk + 1;
		
	}
	
	public void insert(UserBean been) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		PreparedStatement st = con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		
		st.setInt(1, nextPk());
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
	
	public List search(UserBean been) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceadvancejava","root","root");
		
		StringBuffer sql = new StringBuffer("select * from user where 1 = 1");
		
		if(been != null) {
			
			if(been.getFirstName() != null && been.getFirstName().length() > 0) {
				
				sql.append(" and firstName like '"+ been.getFirstName()+"%'");
				
			}
			
			if(been.getLastName() != null && been.getLastName().length() > 0) {
				
				sql.append(" and lastName like '"+ been.getLastName()+"%'");
				
			}
			if(been.getLoginId() != null && been.getLoginId().length() > 0) {
	
				sql.append(" and loginId like '"+ been.getLoginId()+"%'");
	
			}

			if(been.getPassword() != null && been.getPassword().length() > 0) {
	
				sql.append(" and password like '"+ been.getPassword()+"%'");
	
			}

			if(been.getDob() != null && been.getDob().getTime() > 0) {
				
				Date d = new Date(been.getDob().getTime());
	
				sql.append(" and dob like '"+d+"%'");
	
			}

			if(been.getAddress() != null && been.getAddress().length() > 0) {
	
				sql.append(" and address like '"+ been.getAddress()+"%'");
	
			}
			
		}
		
		PreparedStatement st = conn.prepareStatement(sql.toString());
		
		ResultSet rs = st.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getDate(6));
			System.out.println("\t"+rs.getString(7));
			list.add(been);
			
		}
		
		return list;
		
	}

}
