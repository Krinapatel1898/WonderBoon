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
 * Servlet implementation class SelectProductBySubCategoryServlet
 */
public class SelectProductBySubCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int subcategoryID=Integer.parseInt(request.getParameter("subcategoryID"));
		System.out.println("SelectProductBySubCategoryServlet :: subcategoryID :: "+subcategoryID);
		
		HttpSession session=request.getSession(true);
		session.setAttribute("subcategoryID", subcategoryID);
		ProductDao productDao=new ProductDao();
		ArrayList<ProductBean> listofProducts = productDao.getAllProductsBySubCategory(subcategoryID);
		request.setAttribute("listofProducts", listofProducts);
		request.getRequestDispatcher("listProductByCategory.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
