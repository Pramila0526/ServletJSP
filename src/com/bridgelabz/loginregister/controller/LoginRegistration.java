package com.bridgelabz.loginregister.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.loginregister.dao.CustomerDataDAOImp;
import com.bridgelabz.loginregister.model.CustomerP;

import java.util.Scanner;
/**************************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Servlet Class of Login And Registration
 *
 *************************************************************************************************/
@WebServlet("/LoginRegistration")        //
public class LoginRegistration extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException 
		{
			System.out.println("Inside LoginReg");
			CustomerDataDAOImp cd=new CustomerDataDAOImp();
			
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			System.out.println(userName+ " "+password);
			
			String submitType=request.getParameter("Submit");
			CustomerP cust=new CustomerP();
			
			//  username and password is going to check whether registerd or not
			//  by using getCustomer Method of CustomerDataIml Class
			int  value =cd.getCustomer(userName, password);
			
			// Checking whether the value is greater than 0 if it is 
			// then redirection to the Welcome message or next page
			if(value>0)
			{
				request.setAttribute("welcomeMessage",cust.getName());
				response.sendRedirect("usersList.jsp");
			}
			else if(submitType.equals("Register"))
			{
				cust.setName(request.getParameter("name"));
				cust.setPassword(password);
				cust.setUsername(userName);
				cd.registerCustomer(cust);
				request.setAttribute("successMessage","Registration Done,Please Login!!");
				//response.sendRedirect("loginpage.jsp");
			   request.getRequestDispatcher("loginWel.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("message","Data not Found, Please Click on Register \n for registration!!");
				//response.sendRedirect("loginpage.jsp");
				request.getRequestDispatcher("loginMain.jsp").forward(request,response);
			}
		}
	}
