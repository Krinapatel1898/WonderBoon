package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.StoreOwnerDao;
import com.royal.dao.UserDao;

/**
 * Servlet implementation class UserResetPasswordServlet
 */
public class UserResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		int rowseffected=0;
		HttpSession session=request.getSession(true);
		String email= (String)session.getAttribute("email");
		String user_password=request.getParameter("user_password");
		UserDao udao=new UserDao();
		
		rowseffected=udao.updatePassword(email, user_password);
		
		if (rowseffected>0)
		{
			rd=request.getRequestDispatcher("login.jsp");
			
		} else 
		{
			System.out.println("Password Not Updated");
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
