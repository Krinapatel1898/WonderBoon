package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.ProductBean;
import com.royal.dao.ProductDao;

/**
 * Servlet implementation class CheckProductServlet
 */
public class CheckProductServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProductDao productDao = new ProductDao();
		int storeID=Integer.parseInt(request.getParameter("storeID"));		
		System.out.println("CheckProductServlet1 :: storeID ==> "+storeID);
		HttpSession session=request.getSession(true);
		session.setAttribute("storeID", storeID);

		ArrayList<ProductBean> listofProducts = productDao.getAllProducts(storeID);
		request.setAttribute("listofProducts", listofProducts);
		

		request.getRequestDispatcher("listproducts.jsp").forward(request, response);

		
	}  
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
