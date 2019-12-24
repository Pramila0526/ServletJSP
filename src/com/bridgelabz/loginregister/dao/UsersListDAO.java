package com.bridgelabz.loginregister.dao;
import java.util.ArrayList;
import java.util.List;
import com.bridgelabz.loginregister.model.CustomerP;
import java.sql.*;
/*************************************************************************************************************
 * @author :Pramila0526 
 * Purpose :For printing whole table
 *
 ******************************************************************************************************************/
public class UsersListDAO {
	public static List<CustomerP> getList() {
		List<CustomerP> cust = new ArrayList<CustomerP>();
		try {
			String query = "SELECT * FROM customer ";
			Connection con = null;
			CustomerP custObj = null;
			String url = "jdbc:mysql://localhost:3306/employee";

			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "password");//connection established...
			PreparedStatement ps = con.prepareStatement(query);// run the query
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				custObj = new CustomerP();
				custObj.setUsername(rs.getString(1));
				custObj.setName(rs.getString(3));
				cust.add(custObj);
			}
			System.out.println(cust);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		 return cust;
	}
}
