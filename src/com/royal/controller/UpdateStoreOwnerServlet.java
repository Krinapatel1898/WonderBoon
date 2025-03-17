package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.StoreOwnerBean;
import com.royal.dao.StoreOwnerDao;
import com.royal.dao.StoreOwnerRegistrationDao;


public class UpdateStoreOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String store_ownerName = request.getParameter("store_ownerName");
		String store_ownerContact = request.getParameter("store_ownerContact");
		String store_ownerEmail = request.getParameter("store_ownerEmail");
		String store_ownerPassword = request.getParameter("store_ownerPassword");
		
		
		StoreOwnerBean storeownerBean = new StoreOwnerBean(store_ownerName,store_ownerContact,store_ownerEmail,store_ownerPassword);     		
		StoreOwnerDao storeownerDao = new StoreOwnerDao(); 
		StoreOwnerRegistrationDao storeownerregistrationDao=new StoreOwnerRegistrationDao();
		//System.out.println(name);                                          
		                                                                     
		int rowsEffected = storeownerDao.update(storeownerBean);
		
		RequestDispatcher rd = null;
		
		if (rowsEffected > 0) 
		{if (request.getParameter("remember") != null) 
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
		
		HttpSession session = request.getSession(true);
		session.setAttribute("store_ownerEmail", store_ownerEmail);
		session.setAttribute("store_ownerName", store_ownerName);
		session.setAttribute("store_ownerPassword", store_ownerPassword);
		session.setAttribute("store_ownerContact", store_ownerContact);
		rd=request.getRequestDispatcher("index.jsp");}
		else 	
		{
			rd = request.getRequestDispatcher("store_owner_registration.jsp");
		}
		
		rd.forward(request, response);
	}

	

}
