package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.AdminDao;
import com.royal.dao.StoreOwnerDao;

/**
 * Servlet implementation class AdminResetPasswordServlet
 */
public class AdminResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		int rowseffected=0;
		HttpSession session=request.getSession(true);
		String admin_Email= (String)session.getAttribute("admin_Email");
		String admin_password=request.getParameter("admin_password");
		AdminDao adminDao=new AdminDao();
		
		rowseffected=adminDao.updatePassword(admin_Email, admin_password);
		
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
		doGet(request, response);
	}

}
