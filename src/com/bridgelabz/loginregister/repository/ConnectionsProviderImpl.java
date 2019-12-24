package com.bridgelabz.loginregister.repository;
import java.sql.*;
/*************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :Establishing Connection
 *
 ******************************************************************************************************************/
public class ConnectionsProviderImpl implements ConnectionsProvider {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("connection");
			return con;
		} catch (Exception exc) {
			System.out.println(exc);
		}
		return null;
	}
}
