package com.revature.util;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class ConnectionFactory {

	//private static final Properties props = getJdbcProperties();
	
	// Private Constructor to enforce usage of factory method
	private ConnectionFactory() {}
	
	public static Connection getConnection() {
		try {
			/*
			 * return DriverManager.getConnection(props.getProperty("jdbc.url"),
			 * props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
			 */
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(System.getenv("JDBC_URL"), 
					System.getenv("JDBC_USERNAME"), 
					System.getenv("JDBC_PASSWORD"));
		} catch (SQLException e) {
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Message: " + e.getMessage());
			throw new RuntimeException("Failed to get database connection");
		} catch (ClassNotFoundException e) {
			System.err.println("Failed to locate JDBC Driver");
			throw new RuntimeException("failed to locate JDBC driver");
		} 
	}
	
/*	private static Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load application.properties");
		} 
		return props;}
	*/
}
