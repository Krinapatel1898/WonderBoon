package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.StoreOwnerBean;
import com.royal.dao.StoreOwnerDao;

/**
 * Servlet implementation class ListStoreOwnerServlet
 */
public class ListStoreOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StoreOwnerDao storeownerDao = new StoreOwnerDao();
		HttpSession session=request.getSession();
		
		ArrayList<StoreOwnerBean> getAllStoreOwners = storeownerDao.getAllStoreOwners();
		
		request.setAttribute("getAllStoreOwners", getAllStoreOwners);
		request.getRequestDispatcher("list_of_storeOwners.jsp").forward(request, response);
	}

	
}
