package com.royal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.ProductBean;
import com.royal.bean.StoreBean;
import com.royal.dao.ProductDao;
import com.royal.dao.StoreDao;

/**
 * Servlet implementation class EditProductServlet
 */
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int productID = Integer.parseInt(request.getParameter("productID"));		
		System.out.println("EditProductServlet productID :- " + productID);

		HttpSession session=request.getSession(true);
		session.setAttribute("productID", productID);
		ProductDao productDao = new ProductDao();
	
		ProductBean productBean = productDao.getProductByID(productID);
		request.setAttribute("productBean", productBean);

		request.getRequestDispatcher("editproduct.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
