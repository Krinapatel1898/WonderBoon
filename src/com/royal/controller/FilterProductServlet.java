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
 * Servlet implementation class FilterProductServlet
 */
public class FilterProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int categoryID   =Integer.parseInt(request.getParameter("categoryID"));
		int subcategoryID=Integer.parseInt(request.getParameter("subcategoryID"));
		int occasionID   =Integer.parseInt(request.getParameter("occasionID"));
		
		System.out.println("FilterProductServlet :: categoryID    :: "+categoryID   );
		System.out.println("FilterProductServlet :: subcategoryID :: "+subcategoryID);
		System.out.println("FilterProductServlet :: occasionID    :: "+occasionID   );
		
		
		HttpSession session=request.getSession(true);
		session.setAttribute("categoryID", categoryID);
		session.setAttribute("subcategoryID",subcategoryID );
		session.setAttribute("occasionID   ",occasionID    );
		ProductDao productDao=new ProductDao();
		ArrayList<ProductBean> listofProducts = productDao.FilterProducts(categoryID,subcategoryID,occasionID);		
		request.setAttribute("listofProducts", listofProducts);
		request.getRequestDispatcher("filter_products.jsp").forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
