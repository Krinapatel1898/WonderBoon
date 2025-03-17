package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.AdminDao;


public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String admin_Email = request.getParameter("admin_Email");
		String admin_password = request.getParameter("admin_password");
		RequestDispatcher rd = null;
		AdminDao adminDao = new AdminDao();
		
		if(adminDao.check(admin_Email, admin_password))
		{
			if (request.getParameter("remember") != null) 
			{
				String remember = request.getParameter("remember");
				System.out.println("remember : " + remember);
				Cookie cStore_ownerEmail = new Cookie("cookemail", admin_Email.trim());
				Cookie cPassword = new Cookie("cookpass", admin_password.trim());
				Cookie cRemember = new Cookie("cookrem", remember.trim());
				cStore_ownerEmail.setMaxAge(60 * 60 * 24 * 365);// 15 days
				cPassword.setMaxAge(60 * 60 * 24 * 365);
				cRemember.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(cStore_ownerEmail);
				response.addCookie(cPassword);
				response.addCookie(cRemember);
			}
			String userName=adminDao.getnameByemail(admin_Email);
			HttpSession session = request.getSession(true);
			session.setAttribute("admin_Email", admin_Email);
			session.setAttribute("admin_Name", userName);
			session.setAttribute("admin_password", admin_password);
			rd=request.getRequestDispatcher("index.jsp");
		}
		else
		{
			request.setAttribute("msg", "Email or Password is Incorrect!");
			rd=request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}

}
