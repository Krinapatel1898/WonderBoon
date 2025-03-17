package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.StoreOwnerRegistrationDao;

/**
 * Servlet implementation class StoreOwnerLoginServlet
 */
public class StoreOwnerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String store_ownerEmail = request.getParameter("store_ownerEmail");
		String store_ownerPassword = request.getParameter("store_ownerPassword");
		RequestDispatcher rd = null;
		StoreOwnerRegistrationDao storeownerregistrationDao = new StoreOwnerRegistrationDao();
		
		
		
		if(storeownerregistrationDao.check(store_ownerEmail, store_ownerPassword))
		{
			if (request.getParameter("remember") != null) 
			{
				String remember = request.getParameter("remember");
				System.out.println("remember : " + remember);
				Cookie cStore_ownerEmail = new Cookie("cookemail", store_ownerEmail.trim());
				Cookie cPassword = new Cookie("cookpass", store_ownerPassword.trim());
				Cookie cRemember = new Cookie("cookrem", remember.trim());
				cStore_ownerEmail.setMaxAge(60 * 60 * 24 * 365);// 15 days
				cPassword.setMaxAge(60 * 60 * 24 * 365);
				cRemember.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(cStore_ownerEmail);
				response.addCookie(cPassword);
				response.addCookie(cRemember);
			}
			String userName=storeownerregistrationDao.getnameByemail(store_ownerEmail);
			String store_ownerContact=storeownerregistrationDao.getContactByEmail(store_ownerEmail);
			HttpSession session = request.getSession(true);
			session.setAttribute("store_ownerEmail", store_ownerEmail);
			session.setAttribute("store_ownerName", userName);
			session.setAttribute("store_ownerPassword", store_ownerPassword);
			session.setAttribute("store_ownerContact", store_ownerContact);
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
