package com.royal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogoutServlet
 */
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie cEmail = new Cookie("cookemail", null);
		Cookie cPassword = new Cookie("cookpass", null);
		Cookie cRemember = new Cookie("cookrem", null);
		cEmail.setMaxAge(0);
		cPassword.setMaxAge(0);
		cRemember.setMaxAge(0);
		response.addCookie(cEmail);
		response.addCookie(cPassword);
		response.addCookie(cRemember);
		
		request.getRequestDispatcher("login.jsp").include(request, response);  
        HttpSession session=request.getSession();  
        session.invalidate();
	}

}
