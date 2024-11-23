package practice.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// 1:
public final class JDBCDataSource {
	
// 2 :
	private JDBCDataSource() {
		// TODO Auto-generated constructor stub
	}

// 3 :
	private static JDBCDataSource datasource = null;
	private ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("practice.bundle.system");
	
// 4 :
	public static JDBCDataSource getInstance() {
	
		if(datasource == null) {
		
			datasource = new JDBCDataSource();
		
			datasource.cpds = new ComboPooledDataSource();
		
			try {
			
				datasource.cpds.setDriverClass(rb.getString("driver"));
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("password"));
				datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initial")));
				datasource.cpds.setMaxAdministrativeTaskTime(Integer.parseInt(rb.getString("max")));
				datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("increment")));
		
			} catch (PropertyVetoException e) {
			
				System.out.println(e);
			
				e.printStackTrace();
			
			}
	
		}	
	
		return datasource;
		
	}
	
// 5 :
	public static Connection getConnection() throws Exception {
		
		return getInstance().cpds.getConnection();
		
	}
	
	public static void closeConnection(Connection connection) {
		
		if(connection != null ) {
			
			try {
				
				connection.close();
			
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void rollbackConnection(Connection connection) throws Exception {
		
		if(connection != null) {
			
			try {
	
				connection.rollback();
			
			} catch (SQLException e) {
				
				throw new Exception(e.toString());
				
			}
			
		}
		
	}

}
