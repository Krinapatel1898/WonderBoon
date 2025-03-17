package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.dao.StoreDao;
import com.royal.dao.StoreOwnerDao;

/**
 * Servlet implementation class DeleteStoreOwnerServlet
 */
public class DeleteStoreOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		int store_ownerID=Integer.parseInt(request.getParameter("store_ownerID"));
		
		StoreOwnerDao storeownerDao=new StoreOwnerDao();
		
		int rowsEffected = storeownerDao.delete(store_ownerID);
		
		RequestDispatcher rd = null;
		if(rowsEffected > 0) 
		{
			rd = request.getRequestDispatcher("ListStoreOwnerServlet");
		}else {
			
			rd = request.getRequestDispatcher("ListStoreOwnerServlet");
		}
		
		rd.forward(request, response);
	}

	

}
