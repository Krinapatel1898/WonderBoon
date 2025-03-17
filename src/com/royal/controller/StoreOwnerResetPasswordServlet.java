package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.StoreOwnerDao;

/**
 * Servlet implementation class ResetPasswordServlet
 */
public class StoreOwnerResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		int rowseffected=0;
		HttpSession session=request.getSession(true);
		String store_ownerEmail= (String)session.getAttribute("store_ownerEmail");
		String store_ownerPassword=request.getParameter("store_ownerPassword");
		StoreOwnerDao sdao=new StoreOwnerDao();
		
		rowseffected=sdao.updatePassword(store_ownerEmail, store_ownerPassword);
		
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
