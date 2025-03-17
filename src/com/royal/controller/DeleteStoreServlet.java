package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.dao.StoreDao;

/**
 * Servlet implementation class DeleteStoreServlet
 */
public class DeleteStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int storeID=Integer.parseInt(request.getParameter("storeID"));
		
		StoreDao storeDao=new StoreDao();
		
		int rowsEffected = storeDao.delete(storeID);
		
		RequestDispatcher rd = null;
		if(rowsEffected > 0) 
		{
			rd = request.getRequestDispatcher("ListStoreServlet");
		}else {
			
			rd = request.getRequestDispatcher("ListStoreServlet");
		}
		
		rd.forward(request, response);
	}


}
