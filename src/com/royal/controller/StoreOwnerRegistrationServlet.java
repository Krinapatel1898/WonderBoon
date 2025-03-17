package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.StoreOwnerRegistrationBean;
import com.royal.dao.StoreOwnerRegistrationDao;

/**
 * Servlet implementation class StoreOwnerRegistrationServlet
 */
public class StoreOwnerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String store_ownerName = request.getParameter("store_ownerName");
		String store_ownerContact = request.getParameter("store_ownerContact");
		String store_ownerEmail = request.getParameter("store_ownerEmail");
		String store_ownerPassword = request.getParameter("store_ownerPassword");
		
		
		StoreOwnerRegistrationBean storeownerregistrationBean = new StoreOwnerRegistrationBean(store_ownerName,store_ownerContact,store_ownerEmail,store_ownerPassword);     		
		StoreOwnerRegistrationDao storeownerregistrationDao = new StoreOwnerRegistrationDao(); 
		//System.out.println(name);                                          
		                                                                     
		int rowsEffected = storeownerregistrationDao.insert(storeownerregistrationBean);
		
		RequestDispatcher rd = null;
		
		if (rowsEffected > 0) 
		{
			HttpSession session=((HttpServletRequest) request).getSession(true);
			session.setAttribute("store_ownerEmail", store_ownerEmail);
	        session.setAttribute("store_ownerName",store_ownerName);
			rd = request.getRequestDispatcher("index.jsp");
		}
		else 	
		{
			rd = request.getRequestDispatcher("store_owner_registration.jsp");
		}
		
		rd.forward(request, response);
	}
	

	

}
