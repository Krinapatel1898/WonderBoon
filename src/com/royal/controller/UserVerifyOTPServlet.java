package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserVerifyOTPServlet
 */
public class UserVerifyOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		HttpSession session=request.getSession(true);
		String OriginalOTP=(String)session.getAttribute("OriginalOTP");
		
		String userOTP=request.getParameter("userOTP");
		
		if (userOTP.equals(OriginalOTP)) 
		{
			rd=request.getRequestDispatcher("resetpassword.jsp");			
		}
		else 
		{
			rd=request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
