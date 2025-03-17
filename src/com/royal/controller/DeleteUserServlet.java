package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.dao.UserDao;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int userID=Integer.parseInt(request.getParameter("userID"));
		
		UserDao userDao=new UserDao();
		
		int rowsEffected = userDao.delete(userID);
		
		RequestDispatcher rd = null;
		if(rowsEffected > 0) 
		{
			rd = request.getRequestDispatcher("ListUserServlet");
		}else {
			
			rd = request.getRequestDispatcher("ListUserServlet");
		}
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
