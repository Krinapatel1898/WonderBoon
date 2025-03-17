package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.ProductDao;
import com.royal.dao.WishListDao;

/**
 * Servlet implementation class DeleteFromWishListServlet
 */
public class DeleteFromWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		int productID=Integer.parseInt(request.getParameter("productID"));
		int userID=(Integer) session.getAttribute("userID");
		WishListDao wishListDao=new WishListDao();
		
		int rowsEffected = wishListDao.DeleteFromWishList(productID,userID);
		
		RequestDispatcher rd = null;
		if(rowsEffected > 0) 
		{
			rd = request.getRequestDispatcher("ListWishListProductServlet");
		}else {
			
			rd = request.getRequestDispatcher("ListWishListProductServlet");
		}
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
