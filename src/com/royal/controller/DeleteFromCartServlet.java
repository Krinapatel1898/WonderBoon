package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.ProductDao;

/**
 * Servlet implementation class DeleteFromCartServlet
 */
public class DeleteFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(true);
		int productID=Integer.parseInt(request.getParameter("productID"));
		int userID=(Integer) session.getAttribute("userID");
		ProductDao productDao=new ProductDao();
		
		int rowsEffected = productDao.DeleteFromCart(productID,userID);
		
		RequestDispatcher rd = null;
		if(rowsEffected > 0) 
		{
			rd = request.getRequestDispatcher("ListCartProductServlet");
		}else {
			
			rd = request.getRequestDispatcher("ListCartProductServlet");
		}
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
