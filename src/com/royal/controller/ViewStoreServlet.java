package com.royal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.bean.StoreBean;
import com.royal.dao.StoreDao;

/**
 * Servlet implementation class ViewStoreServlet
 */
public class ViewStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int storeID = Integer.parseInt(request.getParameter("storeID"));
		System.out.println("ViewStoreServlet: store_id : "+ storeID);
		StoreDao  storeDao = new StoreDao();
		StoreBean storeBean =storeDao.getStoreByPK(storeID);
		
		request.setAttribute("storeBean", storeBean);
		
		request.getRequestDispatcher("storedetail.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
