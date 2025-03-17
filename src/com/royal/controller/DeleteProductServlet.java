package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.dao.ProductDao;
import com.royal.dao.StoreDao;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int productID=Integer.parseInt(request.getParameter("productID"));
		
		ProductDao productDao=new ProductDao();
		
		int rowsEffected = productDao.delete(productID);
		
		RequestDispatcher rd = null;
		if(rowsEffected > 0) 
		{
			rd = request.getRequestDispatcher("ListProductServlet");
		}else {
			
			rd = request.getRequestDispatcher("ListProductServlet");
		}
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
