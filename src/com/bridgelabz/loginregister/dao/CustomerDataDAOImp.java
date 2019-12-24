package com.bridgelabz.loginregister.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bridgelabz.loginregister.model.CustomerP;
import com.bridgelabz.loginregister.repository.ConnectionsProviderImpl;

/*************************************************************************************************************
 * @author :Pramila0526 Purpose :DAO implementation class including 2 methods
 *         for login and registration
 *
 ******************************************************************************************************************/
public class CustomerDataDAOImp implements CustomerDataDAO {
	Connection con = null;
	PreparedStatement pstmt = null;

	// Method to register Customers using inser query
	public int registerCustomer(CustomerP cust) {
		int status = 0;
		try {
			con = ConnectionsProviderImpl.getConnection();
			pstmt = con.prepareStatement("insert into customer values(?,?,?)");
			pstmt.setString(1, cust.getUsername());
			pstmt.setString(2, cust.getPassword());
			pstmt.setString(3, cust.getName());

			status = pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	// Method to Login Customers using
	public int getCustomer(String username, String password) {
		int i = 0;
		CustomerP cust = new CustomerP();
		try {
			con = ConnectionsProviderImpl.getConnection();
			System.out.println("after connection");
			pstmt = con.prepareStatement(" select * from customer where username=? && password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			System.out.println("user" + username);
			System.out.println("passoword" + password);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				cust.setUsername(rs.getString(1));
				cust.setPassword(rs.getString(2));
				cust.setName(rs.getString(3));
				i++;
				System.out.println(cust.getName());
				System.out.println(cust.getUsername());
				System.out.println(cust.getPassword());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
}
