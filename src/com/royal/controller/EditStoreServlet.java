package com.royal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.bean.StoreBean;
import com.royal.dao.StoreDao;

/**
 * Servlet implementation class EditStoreServlet
 */
public class EditStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		int storeID = Integer.parseInt(request.getParameter("storeID"));
		System.out.println("EditStoreServlet storeid :- " + storeID);
	
		StoreDao storeDao = new StoreDao();
	
		StoreBean storeBean = storeDao.getStoreByID(storeID);
		System.out.println(storeID+", "+storeBean.getStore_Name()+", "+storeBean.getStore_address());
		request.setAttribute("storeBean", storeBean);
		System.out.println("EditStoreServlet storeid2 :- " + storeBean.getStoreID());

		request.getRequestDispatcher("editstore.jsp").forward(request, response);
	}
}
