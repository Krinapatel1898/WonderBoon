package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.UserDao;
import com.royal.dao.UserRegistrationDao;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserRegistrationDao userregistrationDao = new UserRegistrationDao();
		String email = request.getParameter("email");
		String user_password = request.getParameter("user_password");
		int userID=userregistrationDao.getIdByEmail(email);
		RequestDispatcher rd = null;
		
		
		if(userregistrationDao.check(email, user_password))
		{
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
			String userName=userregistrationDao.getnameByemail(email);
			String contact_no=userregistrationDao.getContactByEmail(email);
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setAttribute("fullname", userName);
			session.setAttribute("user_password", user_password);
			session.setAttribute("contact_no", contact_no);
			session.setAttribute("userID", userID);
			rd=request.getRequestDispatcher("home.jsp");
		}
		else
		{
			request.setAttribute("msg", "Incorrect Email or Password");
			rd=request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}

	

}
