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
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProductDao pDao=new ProductDao();
		HttpSession session=request.getSession(true);
	
		String Gender=request.getParameter("Gender");
		String Age=request.getParameter("Age");
		int occasionID=Integer.parseInt(request.getParameter("occasionID"));
		
		session.setAttribute("Gender", Gender);
		session.setAttribute("Age", Age);
		session.setAttribute("occasionID", occasionID);
		
		System.out.println("ProductListServlet :: Gender :: "+Gender);
		System.out.println("ProductListServlet :: Age :: "+Age);
		System.out.println("ProductListServlet :: OccasionID :: "+occasionID);
		
		ArrayList<ProductBean> listofProducts = pDao.sortProducts(Gender,Age,occasionID);
		request.setAttribute("listofProducts", listofProducts);
		request.getRequestDispatcher("listproducts.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
