package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.StoreBean;
import com.royal.dao.StoreDao;

/**
 * Servlet implementation class StoreListServlet
 */
public class StoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StoreDao storeDao = new StoreDao();
		HttpSession session=request.getSession();
		String store_ownerEmail=request.getParameter("store_ownerEmail");
		session.setAttribute("store_ownerEmail", store_ownerEmail);
		System.out.println("StoreListServlet :: store_ownerEmailID ==> "+store_ownerEmail);
		ArrayList<StoreBean> getAllStores = storeDao.getAllStores(store_ownerEmail);		
		request.setAttribute("getAllStores", getAllStores);
		request.getRequestDispatcher("list_of_store.jsp").forward(request, response);

	}

	
}
