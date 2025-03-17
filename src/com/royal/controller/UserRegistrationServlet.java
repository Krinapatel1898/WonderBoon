package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.UserRegistrationBean;
import com.royal.dao.UserRegistrationDao;

/**
 * Servlet implementation class UserRegistrationServlet
 */
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String user_password = request.getParameter("user_password");
		String contact_no = request.getParameter("contact_no");
		
		UserRegistrationBean userregistrationBean = new UserRegistrationBean(fullname, email,user_password,contact_no);     		
		UserRegistrationDao userregistrationDao = new UserRegistrationDao();
		//System.out.println(name);
		
		int rowsEffected = userregistrationDao.insert(userregistrationBean);
		
		RequestDispatcher rd = null;
		
		if (rowsEffected > 0) 
		{
			HttpSession session=((HttpServletRequest) request).getSession(true);
			session.setAttribute("email", email);
	        session.setAttribute("fullname",fullname);
			rd = request.getRequestDispatcher("home.jsp");
		}
		else 	
		{
			rd = request.getRequestDispatcher("index.jsp");
		}
		
		rd.forward(request, response);
	}

	

}
