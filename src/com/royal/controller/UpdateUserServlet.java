package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email  = request.getParameter("email");
		String fullname  = request.getParameter("fullname");
		String user_password  = request.getParameter("user_password");
		String contact_no  = request.getParameter("contact_no");

		
		System.out.println("UpdateUserServlet : email :- "+email);
		System.out.println("UpdateUserServlet : fullname :- "+fullname);
		System.out.println("UpdateUserServlet : user_password :- "+user_password);
		System.out.println("UpdateUserServlet : contact_no :- "+contact_no);
		
		UserBean  userBean = new UserBean(fullname,email,user_password,contact_no) ;
		
		UserDao userDao = new UserDao();
		
		int rowsEffected = userDao.update(userBean);
		if (request.getParameter("remember") != null) 
		{
			String remember = request.getParameter("remember");
			System.out.println("remember : " + remember);
			Cookie cEmail = new Cookie("cookemail", email.trim());
			Cookie cPassword = new Cookie("cookpass", user_password.trim());
			Cookie cRemember = new Cookie("cookrem", remember.trim());
			cEmail.setMaxAge(60 * 60 * 24 * 365);// 15 days
			cPassword.setMaxAge(60 * 60 * 24 * 365);
			cRemember.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(cEmail);
			response.addCookie(cPassword);
			response.addCookie(cRemember);
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		session.setAttribute("user_password", user_password);
		session.setAttribute("contact_no", contact_no);
		
		RequestDispatcher rd = null;
		if (rowsEffected > 0 ) 
		{
			rd = request.getRequestDispatcher("home.jsp");
		} else 
		{
			rd = request.getRequestDispatcher("profile.jsp");
		}
		rd.forward(request, response);
	}

	
}
