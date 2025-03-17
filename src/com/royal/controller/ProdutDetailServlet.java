package com.royal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.ProductBean;
import com.royal.dao.ProductDao;

/**
 * Servlet implementation class ProdutDetailServlet
 */
public class ProdutDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(true);
		int productID=Integer.parseInt(request.getParameter("productID"));
		System.out.print("ProdutDetailServlet :: productID ==> "+productID);
		
		session.setAttribute("productID", productID);
		ProductDao productDao=new ProductDao();
		ProductBean productBean=productDao.getProductByID(productID);
		session.setAttribute("productBean", productBean);
		request.setAttribute("productBean", productBean);
		request.getRequestDispatcher("product_detail.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
