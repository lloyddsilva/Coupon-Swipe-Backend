package couponswipe.data.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.*;

public class ConnectionPoolImpl implements IConnectionPool{
	
	private static ConnectionPoolImpl instance = null;
	private HikariDataSource ds = null;
	
	
	
	@Override
	public Connection getConnection() throws SQLException {
		
		Connection connection = null;
		 String dbUrl = "jdbc:mysql://localhost/test";
	        String dbClass = "com.mysql.jdbc.Driver";
	        String username = "root";
	        String password = "password";
	        System.out.println(1);
	        try {

	            Class.forName(dbClass);
	             connection = DriverManager.getConnection(dbUrl,
	                username, password);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
		
		return connection;
	}
	
	public static ConnectionPoolImpl getInstance() {
	    if(instance == null){
	        instance = new ConnectionPoolImpl();
	    }
	    
	    return instance;
	}

}