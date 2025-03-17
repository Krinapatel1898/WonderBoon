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
 * Servlet implementation class ListProductServlet
 */
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProductDao productDao = new ProductDao();
		HttpSession session=request.getSession();
		int storeID=(Integer) session.getAttribute("storeID");
		System.out.println("ListProductServlet :: storeID ==> "+storeID);
		ArrayList<ProductBean> listofProducts = productDao.getAllProducts(storeID);
		request.setAttribute("listofProducts", listofProducts);
		request.getRequestDispatcher("listproducts.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
