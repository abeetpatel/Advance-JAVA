package com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");
	
	public int nextPk() throws Exception {
		
		int pk = 0;
		
		Class.forName(rb.getString("driver"));
		
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		
		PreparedStatement st =conn.prepareStatement("select max(id) from marksheet");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			pk = rs.getInt(1);
			
			System.out.println("max id = " +pk);
			
		}return pk +1;
		
	}

	public void add(MarksheetBean been) throws Exception {

		Connection conn = null;
		
		try {
				
		Class.forName("com.mysql.cj.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement st = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");

		st.setInt(1, nextPk());
		st.setString(2, been.getName());
		st.setString(3, been.getRoll_no());
		st.setInt(4, been.getPhysics());
		st.setInt(5, been.getChemistry());
		st.setInt(6, been.getMaths());

		int i = st.executeUpdate();
		
		conn.commit();

		System.out.println("data inserted successfully = " + i);
			
		} catch (Exception e) {
			
			conn.rollback();
			
		}
		
		

	}

	public void update(MarksheetBean been) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement st = conn.prepareStatement(
				"update marksheet set name = ?, roll_no = ?, physics = ?, chemistry = ?, maths = ? where id = ?");

		st.setString(1, been.getName());
		st.setString(2, been.getRoll_no());
		st.setInt(3, been.getPhysics());
		st.setInt(4, been.getChemistry());
		st.setInt(5, been.getMaths());
		st.setInt(6, been.getId());

		int i = st.executeUpdate();

		System.out.println("data updated successfully = " + i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement st = conn.prepareStatement("delete from marksheet where id = ?");

		st.setInt(1, id);
		;

		int i = st.executeUpdate();

		System.out.println("data deleted succesfully = " + i);

	}

	public MarksheetBean getById(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement st = conn.prepareStatement("select * from marksheet where id =?");

		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		MarksheetBean been = null;

		while (rs.next()) {

			been = new MarksheetBean();

			been.setId(rs.getInt(1));
			been.setName(rs.getString(2));
			been.setRoll_no(rs.getNString(3));
			been.setPhysics(rs.getInt(4));
			been.setChemistry(rs.getInt(5));
			been.setMaths(rs.getInt(6));

		}

		return been;

	}

	public List search(MarksheetBean been) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1 = 1");

		if (been != null) {

			if (been.getName() != null && been.getName().length() > 0) {
				sql.append(" and name like '" + been.getName() + "%'");

			}

		}

		System.out.println("sql ==> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			been = new MarksheetBean();

			been.setId(rs.getInt(1));
			been.setName(rs.getString(2));
			been.setRoll_no(rs.getString(3));
			been.setPhysics(rs.getInt(4));
			been.setChemistry(rs.getInt(5));
			been.setMaths(rs.getInt(6));
			list.add(been);

		}

		return list;

	}

	public List getMeritList(MarksheetBean been) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"select id, name, roll_no, physics, chemistry, maths, (physics+chemistry+maths) as total, ((physics+chemistry+maths) / 3) as percentage from marksheet order by total desc limit 0,5");

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			been = new MarksheetBean();

			been.setId(rs.getInt(1));
			been.setName(rs.getString(2));
			been.setRoll_no(rs.getString(3));
			been.setPhysics(rs.getInt(4));
			been.setChemistry(rs.getInt(5));
			been.setMaths(rs.getInt(6));
			
			list.add(been);

		}

		return list;

	}

}