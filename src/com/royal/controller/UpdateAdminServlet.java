package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.AdminBean;
import com.royal.dao.AdminDao;

/**
 * Servlet implementation class UpdateAdminServlet
 */
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(true);
		String admin_Email  = request.getParameter("admin_Email");
		String admin_password  = request.getParameter("admin_password");
		String admin_Name  = (String) session.getAttribute("admin_Name");

		
		
		System.out.println("UpdateAdminServlet : admin_Email  :- "+admin_Email );
		System.out.println("UpdateAdminServlet : admin_password  :- "+admin_password );
		System.out.println("UpdateAdminServlet : admin_Name  :- "+admin_Name );
		
		AdminBean  adminBean = new AdminBean(admin_Email, admin_password) ;
		
		AdminDao adminDao = new AdminDao();
		
		int rowsEffected = adminDao.update(adminBean);
		
		RequestDispatcher rd = null;
		if (rowsEffected > 0) 
		{if (request.getParameter("remember") != null) 
		{
			String remember = request.getParameter("remember");
			System.out.println("remember : " + remember);
			Cookie cadminEmail = new Cookie("cookemail", admin_Email.trim());
			Cookie cPassword = new Cookie("cookpass", admin_password.trim());
			Cookie cRemember = new Cookie("cookrem", remember.trim());
			cadminEmail.setMaxAge(60 * 60 * 24 * 365);// 15 days
			cPassword.setMaxAge(60 * 60 * 24 * 365);
			cRemember.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(cadminEmail);
			response.addCookie(cPassword);
			response.addCookie(cRemember);
		}
		
		session.setAttribute("admin_Email", admin_Email);
		session.setAttribute("admin_Name", admin_Name);
		session.setAttribute("store_ownerPassword", admin_password);
		rd=request.getRequestDispatcher("index.jsp");}
		else 	
		{
			rd = request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}

}
