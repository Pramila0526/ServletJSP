package com.bridgelabz.loginregister.dao;
import com.bridgelabz.loginregister.model.CustomerP;
/*************************************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:DAO interface including 2methods for login and registration
 *
 ******************************************************************************************************************/
public interface CustomerDataDAO {
public int getCustomer(String username,String password);
public int registerCustomer(CustomerP cust);
}